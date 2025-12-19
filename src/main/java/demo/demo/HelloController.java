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

        // --- Initialisation des cocktails ---
        mojito = new Cocktail("Mojito", 8.0, List.of(
                "Ajouter 5cl de rhum",
                "Ajouter menthe fraîche",
                "Ajouter sucre",
                "Écraser les feuilles",
                "Ajouter glace pilée",
                "Compléter avec eau gazeuse"
        ));
        mojito.setIngredientsRequis(List.of("Rhum", "Menthe fraîche", "Sucre", "Glace pilée", "Eau gazeuse"));
        bar.getStock().ajouter(mojito, 20);

        martini = new Cocktail("Martini", 14.00, List.of(
                "Verser 6cl de gin",
                "Ajouter 1cl de vermouth sec",
                "Remuer avec glace",
                "Servir avec une olive"
        ));
        martini.setIngredientsRequis(List.of("Gin", "Vermouth sec", "Olive"));
        bar.getStock().ajouter(martini, 10);

        cosmopolitan = new Cocktail("Cosmopolitan", 10.5, List.of(
                "Verser 4cl de vodka",
                "Ajouter 2cl de triple sec",
                "Ajouter 2cl de jus de cranberry",
                "Ajouter 1cl de jus de citron vert",
                "Secouer et servir"
        ));
        cosmopolitan.setIngredientsRequis(List.of("Vodka", "Triple sec", "Jus de cranberry", "Jus de citron vert"));
        bar.getStock().ajouter(cosmopolitan, 10);

        blueLagoon = new Cocktail("Blue Lagoon", 10.5, List.of(
                "Verser 4cl de vodka",
                "Ajouter 2cl de curaçao bleu",
                "Compléter avec limonade",
                "Servir avec glace"
        ));
        blueLagoon.setIngredientsRequis(List.of("Vodka", "Curaçao bleu", "Limonade"));
        bar.getStock().ajouter(blueLagoon, 10);

        orangina = new Cocktail("Orangina", 1.00, List.of(
                "Verser Orangina frais dans un verre"
        ));
        orangina.setIngredientsRequis(List.of("Orangina"));
        bar.getStock().ajouter(orangina, 20);

        cola = new Cocktail("Cola", 2.5, List.of(
                "Verser Cola frais dans un verre"
        ));
        cola.setIngredientsRequis(List.of("Cola"));
        bar.getStock().ajouter(cola, 20);

        sprite = new Cocktail("Sprite", 2.0, List.of(
                "Verser Sprite frais dans un verre"
        ));
        sprite.setIngredientsRequis(List.of("Sprite"));
        bar.getStock().ajouter(sprite, 20);

        // --- Initialisation du personnel ---
        barman = new Barman("Jean", 1800.0, 50, 1.2, "Oui");
        serveur = new Serveur("Paul", 1600.0, 10, 1.5, "Oui");

        outputArea.appendText("Bar initialisé avec cocktails et ingrédients.\n");
    }

    // Méthodes pour chaque bouton Ajouter
    @FXML protected void ajouterMojito() { ajouterCocktail(mojito); }
    @FXML protected void ajouterMartini() { ajouterCocktail(martini); }
    @FXML protected void ajouterCosmopolitan() { ajouterCocktail(cosmopolitan); }
    @FXML protected void ajouterBlueLagoon() { ajouterCocktail(blueLagoon); }
    @FXML protected void ajouterOrangina() { ajouterCocktail(orangina); }
    @FXML protected void ajouterCola() { ajouterCocktail(cola); }
    @FXML protected void ajouterSprite() { ajouterCocktail(sprite); }

    private void ajouterCocktail(Cocktail c) {
        try {
            if (c == null) {
                outputArea.appendText("❌ Erreur : cocktail non initialisé\n");
                return;
            }
            outputArea.appendText("Préparation de " + c.getNom() + "...\n");
            afficherIngredientsRequis(c);
        } catch (Exception e) {
            outputArea.appendText("❌ Erreur : " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    private void afficherIngredientsRequis(Cocktail c) {
        try {
            Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.setTitle("Recette du " + c.getNom());

            VBox layout = new VBox(15);
            layout.setPadding(new Insets(20));
            layout.setAlignment(Pos.CENTER);

            Label titre = new Label("Ingrédients nécessaires pour " + c.getNom() + " :");
            titre.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

            TextArea ingredientsArea = new TextArea();
            ingredientsArea.setEditable(false);
            ingredientsArea.setPrefHeight(150);
            ingredientsArea.setWrapText(true);

            List<String> ingredients = c.getIngredientsRequis();
            if (ingredients != null && !ingredients.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String ing : ingredients) {
                    sb.append("• ").append(ing).append("\n");
                }
                ingredientsArea.setText(sb.toString());
            } else {
                ingredientsArea.setText("Aucun ingrédient requis");
            }

            // Conteneur pour les deux boutons
            VBox buttonContainer = new VBox(10);
            buttonContainer.setAlignment(Pos.CENTER);

            Button continuer = new Button("Préparer moi-même");
            continuer.setPrefWidth(200);
            continuer.setStyle("-fx-font-size: 14px; -fx-padding: 10px;");
            continuer.setOnAction(e -> {
                popup.close();
                afficherSelectionIngredients(c);
            });

            Button appelBarman = new Button("🍸 Appeler le Barman");
            appelBarman.setPrefWidth(200);
            appelBarman.setStyle("-fx-font-size: 14px; -fx-padding: 10px; -fx-background-color: #2ecc71; -fx-text-fill: white;");
            appelBarman.setOnAction(e -> {
                popup.close();
                preparerCocktailAutomatique(c);
            });

            buttonContainer.getChildren().addAll(appelBarman, continuer);
            layout.getChildren().addAll(titre, ingredientsArea, buttonContainer);

            Scene scene = new Scene(layout, 400, 350);
            popup.setScene(scene);
            popup.show();

        } catch (Exception e) {
            outputArea.appendText("❌ Erreur popup 1 : " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    // NOUVELLE MÉTHODE : Préparation automatique par le barman
    private void preparerCocktailAutomatique(Cocktail c) {
        try {
            outputArea.appendText("\n🍸 " + barman.getNom() + " (Barman) prépare votre " + c.getNom() + "...\n");

            // Vérifier la disponibilité des ingrédients
            List<String> ingredientsRequis = c.getIngredientsRequis();
            List<Ingredient> tousIngredients = bar.getStock().getTousLesIngredients();

            boolean ingredientsDisponibles = true;
            List<Ingredient> ingredientsAUtiliser = new ArrayList<>();

            for (String nomRequis : ingredientsRequis) {
                boolean trouve = false;
                for (Ingredient ing : tousIngredients) {
                    if (ing.getNom().equalsIgnoreCase(nomRequis) && ing.getQuantite() > 0) {
                        ingredientsAUtiliser.add(ing);
                        trouve = true;
                        break;
                    }
                }
                if (!trouve) {
                    outputArea.appendText("❌ Ingrédient manquant : " + nomRequis + "\n");
                    ingredientsDisponibles = false;
                    break;
                }
            }

            if (!ingredientsDisponibles) {
                outputArea.appendText("❌ Le barman ne peut pas préparer le " + c.getNom() + " - Ingrédients manquants\n");
                return;
            }

            // Afficher les étapes de préparation
            outputArea.appendText("\n📋 Étapes de préparation :\n");
            List<String> etapes = c.getEtapesPreparation();
            if (etapes != null && !etapes.isEmpty()) {
                for (int i = 0; i < etapes.size(); i++) {
                    outputArea.appendText("   " + (i + 1) + ". " + etapes.get(i) + "\n");
                }
            } else {
                outputArea.appendText("   Préparation standard\n");
            }

            // Retirer les ingrédients du stock
            for (Ingredient ing : ingredientsAUtiliser) {
                ing.retirer(1);
            }

            // Ajouter le cocktail à la commande
            commande.ajouterCocktail(c, bar.getStock());

            outputArea.appendText("\n✅ " + c.getNom() + " préparé avec succès par " + barman.getNom() + " !\n");
            outputArea.appendText("💰 Ajouté à la commande : " + c.getPrix() + "€\n");

        } catch (Exception e) {
            outputArea.appendText("❌ Erreur lors de la préparation automatique : " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    private void afficherSelectionIngredients(Cocktail c) {
        try {
            Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.setTitle("Ingrédients pour " + c.getNom());

            VBox layout = new VBox(10);
            layout.setPadding(new Insets(15));

            Label titre = new Label("Sélectionnez les ingrédients nécessaires :");
            titre.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

            VBox checkBoxContainer = new VBox(5);
            checkBoxContainer.setPadding(new Insets(10));

            List<Ingredient> tous = bar.getStock().getTousLesIngredients();
            List<String> requis = c.getIngredientsRequis();

            if (tous == null || tous.isEmpty()) {
                outputArea.appendText("❌ Stock vide\n");
                popup.close();
                return;
            }

            List<CheckBox> checkBoxes = new ArrayList<>();
            for (Ingredient ing : tous) {
                CheckBox cb = new CheckBox(ing.getNom() + " (" + ing.getQuantite() + " dispo)");
                cb.setStyle("-fx-font-size: 13px;");
                checkBoxContainer.getChildren().add(cb);
                checkBoxes.add(cb);
            }

            ScrollPane scroll = new ScrollPane(checkBoxContainer);
            scroll.setFitToWidth(true);
            scroll.setPrefHeight(300);

            Button valider = new Button("Valider");
            valider.setPrefWidth(150);
            valider.setStyle("-fx-font-size: 14px; -fx-padding: 10px;");
            valider.setOnAction(e -> {
                List<String> selectionnes = new ArrayList<>();
                for (int i = 0; i < checkBoxes.size(); i++) {
                    if (checkBoxes.get(i).isSelected()) {
                        selectionnes.add(tous.get(i).getNom());
                    }
                }

                if (selectionnes.size() == requis.size() &&
                        requis.stream().allMatch(r -> selectionnes.stream().anyMatch(s -> s.equalsIgnoreCase(r)))) {

                    outputArea.appendText("✅ Commande validée pour " + c.getNom() + "\n");
                    for (int i = 0; i < checkBoxes.size(); i++) {
                        if (checkBoxes.get(i).isSelected()) {
                            tous.get(i).retirer(1);
                        }
                    }
                    commande.ajouterCocktail(c, bar.getStock());
                    popup.close();
                } else {
                    outputArea.appendText("❌ Mauvais ingrédients pour " + c.getNom() + "\n");
                }
            });

            VBox buttonBox = new VBox(valider);
            buttonBox.setAlignment(Pos.CENTER);
            buttonBox.setPadding(new Insets(10));

            layout.getChildren().addAll(titre, scroll, buttonBox);

            Scene scene = new Scene(layout, 450, 450);
            popup.setScene(scene);
            popup.show();

        } catch (Exception e) {
            outputArea.appendText("❌ Erreur popup 2 : " + e.getMessage() + "\n");
            e.printStackTrace();
        }
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

        // Remplir tous les ingrédients à leur quantité maximale
        List<Ingredient> ingredients = bar.getStock().getTousLesIngredients();

        if (ingredients == null || ingredients.isEmpty()) {
            outputArea.appendText("❌ Aucun ingrédient dans le stock\n");
            return;
        }

        int quantiteMax = 50; // Quantité maximale par ingrédient

        for (Ingredient ing : ingredients) {
            int quantiteActuelle = ing.getQuantite();
            int aAjouter = quantiteMax - quantiteActuelle;

            if (aAjouter > 0) {
                ing.ajouter(aAjouter);
                outputArea.appendText("✅ " + ing.getNom() + " : " + quantiteActuelle + " → " + ing.getQuantite() + "\n");
            } else {
                outputArea.appendText("✓ " + ing.getNom() + " : déjà plein (" + quantiteActuelle + ")\n");
            }
        }

        outputArea.appendText("\n🎉 Stock rempli avec succès !\n");
    }
}