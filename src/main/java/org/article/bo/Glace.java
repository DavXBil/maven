package org.article.bo;

import java.time.LocalDate;

public class Glace extends ProduitPerissable {
	String parfum;
	int temperatureConservation;
	public Glace(LocalDate dateLimiteConso, String marque, String libelle,int temperatureConservation,String parfum, long qteStock, float prixUnitaire) {
		super(dateLimiteConso, marque, libelle, qteStock, prixUnitaire);
		this.temperatureConservation=temperatureConservation;
		this.parfum=parfum;
	}
	public Glace(long refProd, LocalDate dateLimiteConso, String marque, String libelle, long qteStock,
			float prixUnitaire, String parfum, int temperatureConservation) {
		super(refProd, dateLimiteConso, marque, libelle, qteStock, prixUnitaire);
		this.parfum = parfum;
		this.temperatureConservation = temperatureConservation;
	}
	public String getParfum() {
		return parfum;
	}
	public void setParfum(String parfum) {
		this.parfum = parfum;
	}
	public int getTemperatureConservation() {
		return temperatureConservation;
	}
	public void setTemperatureConservation(int temperatureConservation) {
		this.temperatureConservation = temperatureConservation;
	}
	@Override
	public String toString() {
		return "Glace ["+super.toString()+",parfum="+ parfum + ", temperatureConservation=" + temperatureConservation + ", toString()="
				+ "]";
	}
	
}
