package org.article.bll;

import org.article.bo.Produit;
import org.article.dal.DALException;
import org.article.dal.DAO;
import org.article.dal.DAOFactory;

import java.util.List;

public class ProduitManager {
private static volatile ProduitManager instance=null;
private static DAO<Produit> impl;
private ProduitManager() {
	impl = DAOFactory.getProduitsDAO();
}

public final static ProduitManager getInstance() {
	if(ProduitManager.instance==null)
	{
		synchronized(ProduitManager.class)
		{
			if(ProduitManager.instance==null)
			{
				ProduitManager.instance=new ProduitManager();
			}
		}
	}
	return ProduitManager.instance;
}

public List<Produit> getProduits() throws BLLException
{
	List<Produit> lesProds=null;
	try {
		lesProds=impl.selectAll();
	} catch (DALException e) {
		// TODO Auto-generated catch block
		throw new BLLException("Erreur lors de la récupération des éléments chimiques",e);
	}
	
	return lesProds;
}
public void ajouteProduit(Produit  produit) throws BLLException
{
	if(produit.getRefProd()!=0)
	{
		throw new BLLException("Element chimique déjà existant");
	}	
	valider(produit);
	try {
		impl.insert(produit);
	} catch (DALException e) {
		// TODO Auto-generated catch block
		throw new BLLException("Erreur lors de l'ajout de l'élément chimique "+produit,e);
	}
	
}
public void supprimerProduit(Produit  produit) throws BLLException {
	try {
		valider(produit);
		impl.delete(produit);
	} catch (DALException e) {
		// TODO Auto-generated catch block
		throw new BLLException("Erreur lors de la suppression de l'élément chimique "+produit,e);

	}
}
public void modifierProduit(Produit  produit) throws BLLException
{
	valider(produit);
	try {
		impl.update(produit);
	} catch (DALException e) {
		// TODO Auto-generated catch block
		throw new BLLException("Erreur lors de la modification de l'élément chimique "+produit,e);
	}
	
}


private void valider(Produit produit) throws BLLException
{
	boolean valide=true;
	StringBuilder sb= new StringBuilder();
	if (produit==null)
	{
		throw new BLLException("Produit ne peut pas être null");
	}
	/*if (produit.getNumAtomique()<1)
	{
		sb.append("Le numéro atomique doit être positif!");
		valide=false;
	}*/
	/*if (produit.getMasseAtomique()<1)
	{
		sb.append("La masse atomique doit être positive!");
		valide=false;
	}*/
	if(!valide) {
		throw new BLLException(sb.toString());
	}
	
}


}
