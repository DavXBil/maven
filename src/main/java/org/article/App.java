package org.article;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.article.bll.BLLException;
import org.article.bll.ProduitManager;
import org.article.bo.Glace;
import org.article.bo.Pain;
import org.article.bo.Produit;
import org.article.bo.Stylo;

import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    ProduitManager produitMngr = ProduitManager.getInstance();

    private int count = 1;

    private VBox prodTable = new VBox();

    private TextField refField = new TextField();

    private TextField brandField = new TextField();

    private TextField priceField = new TextField();

    private TextField stockField = new TextField();
    private TextField dateLimiteField = new TextField();
    private TextField poidsField = new TextField();
    private TextField parfumField = new TextField();
    private TextField temperatureField = new TextField();
    private TextField couleurField = new TextField();
    private TextField typeMineField = new TextField();

    private TextField typeCarteField = new TextField();

    private Label refLabel = new Label("Référence");
    private Label brandLabel = new Label("Marque");
    private Label priceLabel = new Label("Prix");
    private Label stockLabel = new Label("Prix");


    private Label dateConsoLabel = new Label("Date limite de conservation");
    private Label poidsLabel = new Label("Poids");
    private Label parfumLabel = new Label("Parfum");
    private Label temperatureLabel = new Label("Parfum");
    private Label couleurLabel = new Label("Couleur");
    private Label typeMineLabel = new Label("typeMine");

    private Label typeCarteLabel = new Label("typeCarte");


    private Button precedent = new Button("Précédent");
    private Button nouveau = new Button("Nouveau");
    private Button supprimer = new Button("Supprimer");
    private Button suivant = new Button("Suivant");

    @Override
    public void start(Stage stage) throws BLLException {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();


        List<Produit> produits = produitMngr.getProduits();

        System.out.println(produits);

        Produit produit = produits.get(2);

        supprimer.setOnAction(suppression(produit));

        refField.setText(String.valueOf(produit.getRefProd()));
        refField.setDisable(true);

        brandField.setText(produit.getMarque());
        priceField.setText(String.valueOf(produit.getPrixUnitaire()));
        stockField.setText(String.valueOf(produit.getQteStock()));

        prodTable.getChildren().add(refLabel);
        prodTable.getChildren().add(refField);
        prodTable.getChildren().add(brandLabel);
        prodTable.getChildren().add(brandField);
        prodTable.getChildren().add(priceLabel);
        prodTable.getChildren().add(priceField);
        prodTable.getChildren().add(stockLabel);
        prodTable.getChildren().add(stockField);

        if (produit instanceof Glace) {
            dateLimiteField.setText(String.valueOf(((Glace) produit).getDateLimiteConso()));
            parfumField.setText(((Glace) produit).getParfum());
            temperatureField.setText(String.valueOf(((Glace) produit).getTemperatureConservation()));

            prodTable.getChildren().add(dateConsoLabel);
            prodTable.getChildren().add(dateLimiteField);
            prodTable.getChildren().add(parfumLabel);
            prodTable.getChildren().add(parfumField);
            prodTable.getChildren().add(temperatureLabel);
            prodTable.getChildren().add(temperatureField);

        } else if (produit instanceof Pain) {
            dateLimiteField.setText(String.valueOf(((Glace) produit).getDateLimiteConso()));
            poidsField.setText(String.valueOf(((Pain) produit).getPoids()));

            prodTable.getChildren().add(dateConsoLabel);
            prodTable.getChildren().add(dateLimiteField);
            prodTable.getChildren().add(poidsLabel);
            prodTable.getChildren().add(poidsField);

        } else if (produit instanceof Stylo) {
             couleurField.setText(((Stylo) produit).getCouleur());
             typeMineField.setText(((Stylo) produit).getTypeMine());

            prodTable.getChildren().add(couleurLabel);
            prodTable.getChildren().add(couleurField);
            prodTable.getChildren().add(typeMineLabel);
            prodTable.getChildren().add(typeMineField);

        }

        HBox buttonBox = new HBox();

        buttonBox.getChildren().add(precedent);
        buttonBox.getChildren().add(suivant);



        prodTable.getChildren().add(buttonBox);

        var scene = new Scene(prodTable, 640, 480);

        stage.setTitle("Produits");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public EventHandler<ActionEvent> suppression(Produit produit) throws BLLException {

        produitMngr.supprimerProduit(produit);

        return null;
    }

}