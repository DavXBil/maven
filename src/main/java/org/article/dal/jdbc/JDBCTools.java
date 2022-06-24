package org.article.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.article.dal.DALException;

public class JDBCTools {

	public static Connection getConnection()throws DALException{
		StringBuilder sb = new StringBuilder();
		sb.append("jdbc:mariadb://");
		sb.append(Settings.getProperty("server"));
		sb.append(":");
		sb.append(Settings.getProperty("port"));
		sb.append("/");
		sb.append(Settings.getProperty("db"));
		sb.append("?");
		sb.append("user=");
		sb.append(Settings.getProperty("user"));
		sb.append("&");
		sb.append("password=");
		sb.append(Settings.getProperty("mdp"));


		Connection cnx;
		try {
			cnx = DriverManager.getConnection(sb.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DALException("Erreur de connexion à la base de données",e);
		}
		return cnx;	
	}
}
