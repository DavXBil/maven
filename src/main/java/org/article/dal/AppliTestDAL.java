package org.article.dal;


import org.article.bo.Auteur;
import org.article.bo.CartePostale;
import org.article.bo.Glace;
import org.article.bo.Pain;
import org.article.bo.Produit;
import org.article.bo.Stylo;
import org.article.bo.TypeCartePostale;
import org.article.dal.jdbc.AuteurJDBCImpl;
import org.article.dal.jdbc.ProduitJDBCimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Aurélien Martineau
 */
public class AppliTestDAL {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Produit> produits = null;
        List<Auteur> auteurs=new ArrayList<>();
        ProduitJDBCimpl produitJDBC = new ProduitJDBCimpl();
        AuteurJDBCImpl auteursJDBC = new AuteurJDBCImpl();
        try {
            //Constituer une liste de produits
            produits = new ArrayList<Produit>();

            //********************************
            // tester la gestion des produits
            //********************************

            Stylo styloPapier = new Stylo("Bic", "Evolution original - la Cerisaie", 10000, 1.50f, "gris", "crayon à papier");
            System.out.println("\nREM : Affichage d'un produit Stylo 'Bic'");
            System.out.println(styloPapier.toString());
            System.out.println("---------------------------------------------------------------");
            List<Auteur> lesAuteursDeLaCarte = new ArrayList<>();
            lesAuteursDeLaCarte.add(new Auteur("André", "Dussoliuer"));
            lesAuteursDeLaCarte.add(new Auteur("Béatrice", "Barbante"));
            CartePostale uneCarte = new CartePostale("Carte Sud Bretagne", "La mine d'Or", 10000, 0.80f, lesAuteursDeLaCarte, TypeCartePostale.Paysage);
            System.out.println("\nREM : Affichage d'un produit carte postale");
            System.out.println(uneCarte.toString());
            System.out.println("---------------------------------------------------------------");
            Pain laBaguetteTradition = new Pain("Boulangerie Ducoin", "baguette tradition", 250, 100, 1.0f);
            System.out.println("\nREM : Affichage d'un produit pain");
            System.out.println(laBaguetteTradition.toString());
            System.out.println("---------------------------------------------------------------");
            Glace laGlace = new Glace(LocalDate.of(2020, 2, 18), "Miko", "Cône", -18, "Chocolat", 1000, 2.55f);

            System.out.println("\nREM : Affichage d'un produit glace");
            System.out.println(laGlace.toString());
            System.out.println("---------------------------------------------------------------");

            // Ajout des produits à la liste.

            Pain lePainTradition = new Pain("Boulangerie Ducoin", "pain tradition", 400, 100, 2.0f);
            Pain laBaguette = new Pain("Boulangerie Ducoin", "baguette ordinaire", 250, 800, 0.8f);
            Pain lePain = new Pain("Boulangerie Ducoin", "pain ordinaire", 400, 600, 1.5f);
            Glace laGlaceVanille = new Glace(LocalDate.of(2020, 3, 18), "Miko", "Cône", -18, "Vanille", 1000, 2.55f);
            Glace laGlaceFraise = new Glace(LocalDate.of(2020, 2, 14), "Miko", "Cône", -18, "Fraise", 1000, 2.55f);
            Glace laGlaceCoco = new Glace(LocalDate.of(2020, 2, 12), "Miko", "Cône", -18, "Coco", 1000, 2.55f);
            List<Auteur> lesAuteursDeLaCarteDeux = new ArrayList<>();
            lesAuteursDeLaCarteDeux.add(new Auteur("Pierre", "Degrand"));
            CartePostale uneDeuxiemeCarte = new CartePostale("Carte Sud Bretagne", "Penestin", 10000, 0.80f, lesAuteursDeLaCarteDeux, TypeCartePostale.Paysage);
            List<Auteur> lesAuteursDeLaCarteTrois = new ArrayList<>();
            lesAuteursDeLaCarteTrois.add(new Auteur("Pierre", "Degrand"));
            lesAuteursDeLaCarteTrois.add(new Auteur("Martine", "Dubas"));
            CartePostale uneTroisiemeCarte = new CartePostale("Carte Sud Bretagne", "Guérande", 10000, 0.80f, lesAuteursDeLaCarte, TypeCartePostale.Paysage);
            Stylo styloABille = new Stylo("Stabilo", "Point 88 - la Cerisaie", 10000, 2.50f, "bleu", "Stylo à bille");
            Stylo styloFeutre1 = new Stylo("Stabilo", "Point 88 - la Cerisaie", 10000, 2.50f, "jaune", "feutre");
            Stylo styloFeutre2 = new Stylo("Stabilo", "Point 88 - la Cerisaie", 10000, 2.20f, "rouge", "feutre");
            Stylo styloFeutre3 = new Stylo("Stabilo", "Point 88 - la Cerisaie", 10000, 2.50f, "vert", "feutre");
            Stylo styloFeutre4 = new Stylo("Stabilo", "Point 88 - la Cerisaie", 10000, 2.50f, "orange", "feutre");
            Stylo styloFeutre5 = new Stylo("Stabilo", "Point 88 - la Cerisaie", 10000, 2.30f, "rose", "feutre");

            produits.add(styloPapier);
            produits.add(uneCarte);
            produits.add(laBaguetteTradition);
            produits.add(laGlace);

            produits.add(lePainTradition);
            produits.add(laBaguette);
            produits.add(lePain);
            produits.add(laGlaceVanille);
            produits.add(laGlaceFraise);
            produits.add(laGlaceCoco);
            produits.add(uneDeuxiemeCarte);
            produits.add(uneTroisiemeCarte);
            produits.add(styloABille);
            produits.add(styloFeutre1);
            produits.add(styloFeutre2);
            produits.add(styloFeutre3);
            produits.add(styloFeutre4);
            produits.add(styloFeutre5);


            System.out.println("\nREM : Affichage du catalogue");
            //on affiche la liste des produits
            afficherCatalogue(produits);
            System.out.println("---------------------------------------------------------------");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        System.out.println("/*------------------------------ TEST DAL -------------------------------*/");
   //     try {
          
            auteurs.add(new Auteur("Jules","Verne"));
            auteurs.add(new Auteur("Victor","Hugo"));
            auteurs.add(new Auteur("Jean","de La Fontaine"));
            auteurs.add(new Auteur("Simone","de Beauvoir"));
            auteurs.add(new Auteur("Virginia","Woolf"));
            auteurs.add(new Auteur("Jane","Austen"));
            auteurs.add(new Auteur("Marguerite","Duras"));
            auteurs.add(new Auteur("Alfred","Jarry"));
            Auteur jules=null;
            Auteur jane=null;
   //         afficher(auteursJDBC.selectAll());
        	   System.out.println("/*------------------------------ Insertion des produits du catalogue dans la DAL------------------------------*/");       
        	 try{
        	   for(Auteur auteur:auteurs)
        	   {
        		   auteursJDBC.insert(auteur);
        	   }
               System.out.println("/*------------------------------ Affichage des auteurs -------------------------------*/");
        	   afficher(auteursJDBC.selectAll());
        	   // rechercher si l'auteur Jules Verne existe
        	   if(auteursJDBC.existeByNomPrenom("Jules", "Verne"))
        	   {
        		  jules= auteursJDBC.selectByNomPrenom("Jules","Verne");
        		  System.out.println("/*------------------------------ Modification de Jules Verne -------------------------------*/");
           	   	  jules.setNom("Vernes");
           	   	  auteursJDBC.update(jules);
        	   }
               
        	   System.out.println("/*------------------------------ Affichage des auteurs -------------------------------*/");
        	   afficher(auteursJDBC.selectAll());
         	   if(auteursJDBC.existeByNomPrenom("Jane", "Austen"))
        	   {
        		  jane= auteursJDBC.selectByNomPrenom("Jane","Austen");
        	   }
         	  System.out.println("/*------------------------------ Suppression de Jane Austen -------------------------------*/");
         	  auteursJDBC.delete(jane);
         	   System.out.println("/*------------------------------ Affichage des auteurs -------------------------------*/");
        	   afficher(auteursJDBC.selectAll()); 	      
        	   System.out.println("/*------------------------------ Insertion des produits du catalogue dans la DAL------------------------------*/");       
          	   for(Produit produit:produits)
          	   {
          		   produitJDBC.insert(produit);
          	   }
          	  System.out.println("/*------------------------------ Affichage des produits -------------------------------*/");
          	  afficherCatalogue(produitJDBC.selectAll());
        	  
          	  System.out.println("/*------------------------------ Modification de produit -------------------------------*/");
          	  Produit prod95=produitJDBC.selectById(95);
          	  prod95.setLibelle("new");
          	produitJDBC.update(prod95);
        	  System.out.println("/*------------------------------ Affichage des produits -------------------------------*/");
          	  afficherCatalogue(produitJDBC.selectAll());
          	 System.out.println("/*------------------------------ Suppression d'un produit -------------------------------*/");
             produitJDBC.delete(prod95);
       	  System.out.println("/*------------------------------ Affichage des produits -------------------------------*/");
      	  afficherCatalogue(produitJDBC.selectAll());

             
          	  
        	 
        	 
        	 
        	 } catch (DALException e) {
            e.printStackTrace();
        }
    }
 private static void afficher(List<Auteur> lesAuteurs)
 {
     for (Auteur auteur:lesAuteurs)
     {
    	 System.out.println(auteur.toString());
     }
 }
    private static void afficherCatalogue(List<Produit> produits) {
        for (Produit produit : produits) {
            System.out.println(produit.toString());
        }
    }
}
