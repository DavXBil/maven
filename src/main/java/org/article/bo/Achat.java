package org.article.bo;

import java.util.ArrayList;
import java.util.List;

public class Achat {

		private List<Ligne> lignesAchat= new ArrayList<Ligne>();
	private double montant;

	public Achat(Ligne ligne) {
			lignesAchat.add(ligne) ;
	}

	public final List<Ligne> getLignesPanier() {
		return lignesAchat;
	}


	public void ajouteLigne(Produit p, int qte) {

		Ligne ligneAdding = new Ligne(p, qte);
		lignesAchat.add(ligneAdding);
		calculMontant();
	}

		public final Ligne getLigne(int index) {
		return lignesAchat.get(index);
	}

		@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		bf.append("Achat : \n");
		for (Ligne ligne : lignesAchat) {
			bf.append("ligne " );
			bf.append( lignesAchat.indexOf(ligne)+1 );
		bf.append(" : ");
			bf.append(ligne.toString());
			bf.append("\n");
		}
		bf.append("\nTotal de l'achat : ");
		bf.append(String.format("%.2f euros",getMontant()));
		return bf.toString();
	}

	public void supprimeLigne(int index) {
		lignesAchat.remove(index);
		calculMontant();
	}

	public void modifieLigne(int index, int newQte) {
		this.getLigne(index).setQte(newQte);
		calculMontant();
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	private void calculMontant()
	{
		this.montant = 0;
		for (Ligne ligne : lignesAchat) {
			this.montant=this.montant+ligne.getPrix();
		}

	}

}
