package org.article.dal.jdbc;

import java.io.IOException;
import java.util.Properties;

import org.article.dal.DALException;

public class Settings {
private static Properties properties;
private static void chargement() throws DALException {
	if (properties==null) {
		properties= new Properties();
	
		try {
			properties.load(Settings.class.getClassLoader().getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DALException("erreur lors du chargement du fichiers contenant les informations de connexion à la base de données");
		}
	}
}
public static String getProperty(String key) throws DALException
{
	chargement();
	return properties.getProperty(key);
	
}

}
