package org.article.bo;

public abstract class Produit {
	//Attributs d'instance
	private long refProd;
	private String libelle;
	private String marque;
	private float prixUnitaire;
	private long qteStock;
	public Produit(long refProd,String marque, String libelle,long qteStock, float prixUnitaire) {
		super();
		this.refProd = refProd;
		this.libelle = libelle;
		this.marque = marque;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}
	public Produit(String marque, String libelle,long qteStock, float prixUnitaire) {
		super();
		this.libelle = libelle;
		this.marque = marque;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}
	public long getRefProd() {
		return refProd;
	}
	public void setRefProd(long refProd) {
		this.refProd = refProd;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public long getQteStock() {
		return qteStock;
	}
	public void setQteStock(long qteStock) {
		this.qteStock = qteStock;
	}
	@Override
	public String toString() {
		if (refProd==0) {
			return String.format("libelle=" + libelle + ", marque=" + marque + ", prixUnitaire=%.2f euros, qteStock=" + qteStock,prixUnitaire) ;

		}
		else
		{
			return String.format("refProd=" + refProd + ", libelle=" + libelle + ", marque=" + marque + ", prixUnitaire=%.2f euros, qteStock=" + qteStock,prixUnitaire) ;

		}
	}


}
