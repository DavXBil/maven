package org.article.bo;

import java.time.LocalDate;

public class Pain extends ProduitPerissable {
	int poids;

	public Pain(long refProd, String marque, String libelle, int poids, long qteStock,
			float prixUnitaire) {
		super(refProd, LocalDate.now().plusDays(2), marque, libelle, qteStock, prixUnitaire);
		this.setPoids(poids);
	}
	public Pain(String marque, String libelle, int poids, long qteStock,
			float prixUnitaire) {
		super(LocalDate.now().plusDays(2), marque, libelle, qteStock, prixUnitaire);
		this.setPoids(poids);
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	@Override
	public String toString() {
		return "Pain ["+super.toString() +", poids=" + poids +"g]";
	}

}
