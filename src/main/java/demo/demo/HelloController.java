package demo.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import demo.demo.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML private TextArea outputArea;

    private Bar bar;
    private Client client;
    private Commande commande;
    private Barman barman;
    private Serveur serveur;

    // Références directes aux cocktails
    private Cocktail mojito;
    private Cocktail martini;
    private Cocktail cosmopolitan;
    private Cocktail blueLagoon;
    private Cocktail orangina;
    private Cocktail cola;
    private Cocktail sprite;

    @FXML
    public void initialize() {
        bar = new Bar();
        client = new Client("Alice", 350.0);
        commande = new Commande(client);

        // --- Initialisation des cocktails ---
        mojito = new Cocktail("Mojito", 8.0, List.of(
                "Ajouter 5cl de rhum",
                "Ajouter menthe fraîche",
                "Ajouter sucre",
                "Écraser les feuilles",
                "Ajouter glace pilée",
                "Compléter avec eau gazeuse"
        ));
        mojito.setIngredientsRequis(extraireIngredients(mojito.getEtapesPreparation()));
        bar.getStock().ajouter(mojito, 20);

        martini = new Cocktail("Martini", 14.99, List.of(
                "Verser 6cl de gin",
                "Ajouter 1cl de vermouth sec",
                "Remuer avec glace",
                "Servir avec une olive"
        ));
        martini.setIngredientsRequis(extraireIngredients(martini.getEtapesPreparation()));
        bar.getStock().ajouter(martini, 10);

        cosmopolitan = new Cocktail("Cosmopolitan", 12.5, List.of(
                "Verser 4cl de vodka",
                "Ajouter 2cl de triple sec",
                "Ajouter 2cl de jus de cranberry",
                "Ajouter 1cl de jus de citron vert",
                "Secouer et servir"
        ));
        cosmopolitan.setIngredientsRequis(extraireIngredients(cosmopolitan.getEtapesPreparation()));
        bar.getStock().ajouter(cosmopolitan, 10);

        blueLagoon = new Cocktail("Blue Lagoon", 10.5, List.of(
                "Verser 4cl de vodka",
                "Ajouter 2cl de curaçao bleu",
                "Compléter avec limonade",
                "Servir avec glace"
        ));
        blueLagoon.setIngredientsRequis(extraireIngredients(blueLagoon.getEtapesPreparation()));
        bar.getStock().ajouter(blueLagoon, 10);

        orangina = new Cocktail("Orangina", 1.99, List.of("Verser Orangina frais dans un verre"));
        orangina.setIngredientsRequis(extraireIngredients(orangina.getEtapesPreparation()));
        bar.getStock().ajouter(orangina, 20);

        cola = new Cocktail("Cola", 2.5, List.of("Verser Cola frais dans un verre"));
        cola.setIngredientsRequis(extraireIngredients(cola.getEtapesPreparation()));
        bar.getStock().ajouter(cola, 20);

        sprite = new Cocktail("Sprite", 2.0, List.of("Verser Sprite frais dans un verre"));
        sprite.setIngredientsRequis(extraireIngredients(sprite.getEtapesPreparation()));
        bar.getStock().ajouter(sprite, 20);

        barman = new Barman("Jean", 1800.0, 50, 1.2, "Oui");
        serveur = new Serveur("Paul", 1600.0, 10, 1.5, "Oui");

        // --- Initialisation des ingrédients ---
        bar.getStock().ajouterIngredient(new Ingredient("Rhum", 50, "Alcool"));
        bar.getStock().ajouterIngredient(new Ingredient("Menthe fraîche", 30, "Plante"));
        bar.getStock().ajouterIngredient(new Ingredient("Sucre", 40, "Sucrant"));
        bar.getStock().ajouterIngredient(new Ingredient("Glace pilée", 60, "Froid"));
        bar.getStock().ajouterIngredient(new Ingredient("Eau gazeuse", 25, "Liquide"));

        bar.getStock().ajouterIngredient(new Ingredient("Gin", 40, "Alcool"));
        bar.getStock().ajouterIngredient(new Ingredient("Vermouth sec", 20, "Alcool"));
        bar.getStock().ajouterIngredient(new Ingredient("Olive", 15, "Décoration"));

        bar.getStock().ajouterIngredient(new Ingredient("Vodka", 50, "Alcool"));
        bar.getStock().ajouterIngredient(new Ingredient("Triple sec", 30, "Alcool"));
        bar.getStock().ajouterIngredient(new Ingredient("Jus de cranberry", 25, "Jus"));
        bar.getStock().ajouterIngredient(new Ingredient("Jus de citron vert", 20, "Jus"));

        bar.getStock().ajouterIngredient(new Ingredient("Curaçao bleu", 20, "Alcool"));
        bar.getStock().ajouterIngredient(new Ingredient("Limonade", 30, "Soda"));

        bar.getStock().ajouterIngredient(new Ingredient("Orangina", 40, "Soda"));
        bar.getStock().ajouterIngredient(new Ingredient("Cola", 40, "Soda"));
        bar.getStock().ajouterIngredient(new Ingredient("Sprite", 40, "Soda"));

        outputArea.appendText("Bar initialisé avec cocktails et ingrédients.\n");
    }

    // 🔹 Méthode utilitaire à placer en dehors de initialize()
    private List<String> extraireIngredients(List<String> etapes) {
        List<String> dictionnaire = List.of(
                "rhum", "menthe fraîche", "sucre", "glace pilée", "eau gazeuse",
                "gin", "vermouth sec", "olive",
                "vodka", "triple sec", "jus de cranberry", "jus de citron vert",
                "curaçao bleu", "limonade",
                "orangina", "cola", "sprite"
        );

        List<String> resultat = new ArrayList<>();
        for (String etape : etapes) {
            for (String mot : dictionnaire) {
                if (etape.toLowerCase().contains(mot.toLowerCase()) && !resultat.contains(mot)) {
                    resultat.add(mot);
                }
            }
        }
        return resultat;
    }

    // 🔹 Méthode utilitaire placée en dehors de initialize()

    // Méthodes pour chaque bouton Ajouter
    @FXML protected void ajouterMojito() { ajouterCocktail(mojito); }
    @FXML protected void ajouterMartini() { ajouterCocktail(martini); }
    @FXML protected void ajouterCosmopolitan() { ajouterCocktail(cosmopolitan); }
    @FXML protected void ajouterBlueLagoon() { ajouterCocktail(blueLagoon); }
    @FXML protected void ajouterOrangina() { ajouterCocktail(orangina); }
    @FXML protected void ajouterCola() { ajouterCocktail(cola); }
    @FXML protected void ajouterSprite() { ajouterCocktail(sprite); }



    private void ajouterCocktail(Cocktail c) {
        String preparation = barman.preparerCocktail(c);
        outputArea.appendText("Tentative d'ajout de " + c.getNom() + "...\n");
        outputArea.appendText(preparation + "\n");
        afficherSelectionIngredients(c);
    }

    // Popup affichant les étapes de préparation
    private void afficherPreparation(Cocktail c) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Préparation du " + c.getNom());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.setAlignment(Pos.CENTER_LEFT);

        Label titre = new Label("Ingrédients pour " + c.getNom());
        titre.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        ListView<String> listeIngredients = new ListView<>();
        listeIngredients.getItems().addAll(c.getIngredientsRequis()); // ✅ uniquement les vrais ingrédients
        listeIngredients.setPrefHeight(200);

        Button fermer = new Button("Fermer");
        fermer.setOnAction(e -> popup.close());

        layout.getChildren().addAll(titre, listeIngredients, fermer);

        Scene scene = new Scene(layout, 300, 300);
        popup.setScene(scene);
        popup.showAndWait();
    }

    @FXML
    protected void afficherStock() {
        outputArea.appendText("\n" + bar.getStock().afficher());
    }

    @FXML
    protected void payerCommande() {
        if (commande.estPayee()) {
            outputArea.appendText("Cette commande a déjà été payée.\n");
            return;
        }
        boolean ok = commande.payer();
        if (ok) {
            outputArea.appendText("\n=== Commande payée ===\n");
            outputArea.appendText(commande.afficherCommande());
            bar.ajouterCommande(commande);
            commande.vider();
            commande = new Commande(client);
        } else {
            outputArea.appendText("Solde insuffisant pour payer la commande.\n");
        }
    }

    @FXML
    protected void afficherPersonnel() {
        outputArea.appendText("\n=== Personnel du bar ===\n");
        outputArea.appendText(barman.afficher());
        outputArea.appendText(serveur.afficher());
    }

    @FXML
    protected void remplirStock() {
        outputArea.appendText("\n=== Remplissage du stock ===\n");
        outputArea.appendText(bar.getStock().remplirStock());
    }


    private void afficherSelectionIngredients(Cocktail c) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Ingrédients pour " + c.getNom());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.setAlignment(Pos.CENTER_LEFT);

        Label titre = new Label("Sélectionnez les ingrédients nécessaires :");
        titre.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        VBox liste = new VBox(5);

        List<Ingredient> tous = bar.getStock().getTousLesIngredients();
        List<String> requis = c.getIngredientsRequis(); // ✅ ingrédients attendus

        List<CheckBox> checkBoxes = new ArrayList<>();

        for (Ingredient ing : tous) {
            String nom = ing.getNom();
            CheckBox check = new CheckBox(nom + " (" + ing.getQuantite() + " dispo)");
            check.setSelected(false); // rien n'est coché par défaut
            liste.getChildren().add(check);
            checkBoxes.add(check);
        }

        Button valider = new Button("Valider");
        valider.setOnAction(e -> {
            // Récupère les ingrédients cochés
            List<String> cochés = new ArrayList<>();
            for (int i = 0; i < checkBoxes.size(); i++) {
                if (checkBoxes.get(i).isSelected()) {
                    cochés.add(tous.get(i).getNom());
                }
            }

            // Vérification stricte : mêmes ingrédients, pas d'extra, pas d'oubli
            boolean mêmesTailles = cochés.size() == requis.size();
            boolean contientTous = requis.stream().allMatch(req ->
                    cochés.stream().anyMatch(sel -> sel.equalsIgnoreCase(req))
            );

            if (mêmesTailles && contientTous) {
                outputArea.appendText("✅ Commande validée pour " + c.getNom() + "\n");
                // Retire les ingrédients du stock
                for (int i = 0; i < checkBoxes.size(); i++) {
                    if (checkBoxes.get(i).isSelected()) {
                        Ingredient ing = tous.get(i);
                        ing.retirer(1);
                        outputArea.appendText(" - " + ing.getNom() + " utilisé (reste " + ing.getQuantite() + ")\n");
                    }
                }
                // Ajout à la commande seulement si validé
                commande.ajouterCocktail(c, bar.getStock());
                popup.close();
            } else {
                outputArea.appendText("❌ Commande refusée : ingrédients incorrects ou incomplets pour " + c.getNom() + "\n");
            }
        });

        layout.getChildren().addAll(titre, liste, valider);

        Scene scene = new Scene(layout, 400, 500);
        popup.setScene(scene);
        popup.showAndWait();
    }

    private void afficherIngredients(Cocktail c) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Ingrédients pour " + c.getNom());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.setAlignment(Pos.CENTER_LEFT);

        Label titre = new Label("Ingrédients nécessaires pour " + c.getNom());
        titre.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        ListView<String> listeIngredients = new ListView<>();
        listeIngredients.getItems().addAll(c.getIngredientsRequis()); // ✅ uniquement les vrais ingrédients
        listeIngredients.setPrefHeight(200);

        Button fermer = new Button("Fermer");
        fermer.setOnAction(e -> popup.close());

        layout.getChildren().addAll(titre, listeIngredients, fermer);

        Scene scene = new Scene(layout, 300, 300);
        popup.setScene(scene);
        popup.showAndWait();
    }



}