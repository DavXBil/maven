package org.article.bo;

import java.util.ArrayList;
import java.util.List;

public class Auteur {
long id;
String prenom;
String nom;
List<CartePostale> lesCartes=new ArrayList<>();
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public Auteur(long id, String prenom, String nom) {
	super();
	this.setId(id);
	this.setPrenom(prenom);
	this.setNom(nom);
}
public Auteur(String prenom, String nom) {
this(0,prenom,nom);
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public List<CartePostale> getLesCartes() {
	return lesCartes;
}
public void setLesCartes(List<CartePostale> lesCartes) {
	this.lesCartes = lesCartes;
}
public void ajouterCarte(CartePostale carte) {
	this.lesCartes.add(carte);
}
public void supprimerCarte(CartePostale carte) {
	this.lesCartes.remove(carte);
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Auteur [");
	if(id!=0)
	{
	builder.append("id=");
	builder.append(id);
	}
	builder.append(", prenom=");
	builder.append(prenom);
	builder.append(", nom=");
	builder.append(nom);
	builder.append("]");
	return builder.toString();
}

}
