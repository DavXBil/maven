package org.article.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class ProduitPerissable extends Produit {
	private LocalDate dateLimiteConso;
public ProduitPerissable(long refProd,LocalDate dateLimiteConso, String marque, String libelle, long qteStock, float prixUnitaire) {
		super(refProd, marque, libelle, qteStock, prixUnitaire);
		this.dateLimiteConso=dateLimiteConso;
		// TODO Auto-generated constructor stub
	}
public ProduitPerissable(LocalDate dateLimiteConso,String marque, String libelle, long qteStock, float prixUnitaire) {
	super(marque, libelle, qteStock, prixUnitaire);
	this.dateLimiteConso=dateLimiteConso;
	// TODO Auto-generated constructor stub
}
public LocalDate getDateLimiteConso() {
	return dateLimiteConso;
}
public void setDateLimiteConso(LocalDate dateLimiteConso) {
	this.dateLimiteConso = dateLimiteConso;
}
@Override
public String toString() {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	return super.toString() +", dateLimiteConso=" +dateLimiteConso.format(formatter);
}

}
