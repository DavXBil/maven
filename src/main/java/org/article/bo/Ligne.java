package org.article.bo;

public class Ligne
{
	//Attributs
	private int quantite;
	private Produit produit;
	
	//Constructeurs
	Ligne(Produit p, int qte) 
	{
			setProduit(p);
			setQte(qte);
	}
	
	//Getters et Setters
	public int getQte()
	{
		return quantite;
	}

	public void setQte(int qte)
	{
		this.quantite = qte;
	}
	
	
	
	public Produit getProduit()
	{
		return this.produit;
	}

	private void setProduit(Produit p) 
	{
		this.produit = p;		
		
	}
	
	public float getPrix()
	{
		return produit.getPrixUnitaire()*quantite;
	}
	
	
	//Méthodes
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		buf.append("Ligne [");
		if (produit != null) {
			buf.append("produit=");
			buf.append(getProduit().toString());
			buf.append(", ");
		}
		buf.append(" qte=");
		buf.append(getQte());
		buf.append(", prix=");
		buf.append(String.format("%.2f euros",getPrix()));
		buf.append("]");
		return buf.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
}
