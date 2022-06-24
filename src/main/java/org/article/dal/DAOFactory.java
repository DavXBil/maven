package org.article.dal;

import org.article.bo.Produit;
import org.article.dal.jdbc.ProduitJDBCimpl;

public class DAOFactory {
public static DAO<Produit> getProduitsDAO(){
	DAO<Produit> maDAO = new ProduitJDBCimpl();
	return maDAO;
}
}
