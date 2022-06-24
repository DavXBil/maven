package org.article.bo;

public class Stylo extends Produit {
String couleur;
String typeMine;
public Stylo(long refProd, String marque, String libelle, long qteStock, float prixUnitaire, String couleur,
		String typeMine) {
	super(refProd, marque, libelle, qteStock, prixUnitaire);
	this.couleur = couleur;
	this.typeMine = typeMine;
}
public Stylo(String marque, String libelle, long qteStock, float prixUnitaire, String couleur, String typeMine) {
	super(marque, libelle, qteStock, prixUnitaire);
	this.couleur = couleur;
	this.typeMine = typeMine;
}

public String getCouleur() {
	return couleur;
}
public void setCouleur(String couleur) {
	this.couleur = couleur;
}
public String getTypeMine() {
	return typeMine;
}
public void setTypeMine(String typeMine) {
	this.typeMine = typeMine;
}
@Override
public String toString() {
	return "Stylo ["+super.toString()+", couleur=" + couleur + ", typeMine=" + typeMine  + "]";
}

}
