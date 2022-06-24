package org.article.bo;

import java.util.List;

public class CartePostale extends Produit {
private List<Auteur> lesAuteurs;
private String type;
public CartePostale(long refProd, String marque, String libelle, long qteStock, float prixUnitaire,
		List<Auteur> lesAuteurs, TypeCartePostale type) {
	super(refProd, marque, libelle, qteStock, prixUnitaire);
	this.lesAuteurs = lesAuteurs;
	this.type = type.name();
}
public CartePostale(String marque, String libelle, long qteStock, float prixUnitaire, List<Auteur> lesAuteurs,
		TypeCartePostale type) {
	super(marque, libelle, qteStock, prixUnitaire);
	this.lesAuteurs = lesAuteurs;
	this.type = type.name();
}
public List<Auteur> getLesAuteurs() {
	return lesAuteurs;
}
public void setLesAuteurs(List<Auteur> lesAuteurs) {
	this.lesAuteurs = lesAuteurs;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	StringBuffer sb= new StringBuffer();
	int i=0;
	for(Auteur a : lesAuteurs)
	{
		i++;
		if (i!=1) {
			sb.append(", ");
		}
		sb.append("auteur"+i+"=");
		sb.append(a);
	}
	return "CartePostale ["+ super.toString() +", auteur(s)=" + sb.toString() + ", type=" + type + "]";
}

}
