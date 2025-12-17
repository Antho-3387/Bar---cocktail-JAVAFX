package demo.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;        // <-- AJOUT
import javafx.scene.layout.Background; // <-- AJOUT
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // === Création des cocktails ===
        CocktailAlcool b1 = new CocktailAlcool("Mojito", 8.0, 12.5, 8);
        CocktailAlcool b2 = new CocktailAlcool("Martini", 14.99, 10.0, 10);
        CocktailSansAlcool c1 = new CocktailSansAlcool("Virgin Mojito", 6.5, "Fruitée");
        CocktailSansAlcool c2 = new CocktailSansAlcool("Smoothie Fraise", 5.0, "Sucré");
        CocktailSansAlcool c3 = new CocktailSansAlcool("Eau pétillante", 2.0, "SansSucre");
        CocktailSansAlcool c4 = new CocktailSansAlcool("Orangina", 1.99, "Sucré");

        // === Création du bar ===
        Bar bar = new Bar();

        // Ajout au stock avec quantités
        bar.getStock().ajouter(b1, 10);
        bar.getStock().ajouter(b2, 5);
        bar.getStock().ajouter(c1, 8);
        bar.getStock().ajouter(c2, 12);
        bar.getStock().ajouter(c3, 20);
        bar.getStock().ajouter(c4, 15);

        // === Fenêtre JavaFX ===
        Pane root = new Pane();

        // Bouton pour afficher le stock
        Button stockBtn = new Button("Afficher le stock");
        stockBtn.setLayoutX(50);
        stockBtn.setLayoutY(50);
        stockBtn.setOnAction(e -> {
            System.out.println("=== Stock du bar ===");
            System.out.println(bar.getStock().afficher());
        });

        // === Création des employés ===
        Barman barman = new Barman("Jean", 1800.0, 50, 1.2, "Oui");
        Serveur serveur = new Serveur("Paul", 1600.0, 10, 1.5, "Oui");

        Button personnelBtn = new Button("Afficher le personnel et actions");
        personnelBtn.setLayoutX(50);
        personnelBtn.setLayoutY(100);
        personnelBtn.setOnAction(e -> {
            System.out.println("\n=== Personnel du bar ===");
            System.out.println(barman.afficher());
            System.out.println(serveur.afficher());

            System.out.println("\n=== Actions du personnel ===");
            System.out.println(barman.preparerCocktail(b1));
            System.out.println(serveur.afficher());
        });

        // === Création des clients et commandes ===
        Client client1 = new Client("Alice", 50.0);
        Commande cmd1 = new Commande(client1);
        cmd1.ajouterCocktail(b1, bar.getStock());
        cmd1.ajouterCocktail(c1, bar.getStock());

        Client client2 = new Client("Bob", 30.0);
        Commande cmd2 = new Commande(client2);
        cmd2.ajouterCocktail(b2, bar.getStock());
        cmd2.ajouterCocktail(c2, bar.getStock());

        Button commandesBtn = new Button("Afficher commandes et paiements");
        commandesBtn.setLayoutX(50);
        commandesBtn.setLayoutY(150);
        commandesBtn.setOnAction(e -> {
            System.out.println("\n=== Commande du client Alice ===");
            System.out.println(cmd1.afficherCommande());

            System.out.println("\n=== Commande du client Bob ===");
            System.out.println(cmd2.afficherCommande());

            // Paiement des commandes
            System.out.println("\n=== Paiement Alice ===");
            cmd1.payer();
            System.out.println("\n=== Paiement Bob ===");
            cmd2.payer();

            // Enregistrement des commandes dans le bar
            bar.ajouterCommande(cmd1);
            bar.ajouterCommande(cmd2);

            // Affichage des commandes enregistrées
            System.out.println("\n=== Commandes enregistrées au bar ===");
            System.out.println(bar.afficherCommandes());
        });

        root.getChildren().addAll(stockBtn, personnelBtn, commandesBtn);

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

            // AJOUT : rendre la scène transparente
        scene.setFill(Color.TRANSPARENT);

        primaryStage.initStyle(StageStyle.TRANSPARENT); // AJOUT
        primaryStage.setTitle("Jeu de cocktails");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Jpackage demo.demo;\n" +
                "\n" +
                "import javafx.application.Application;\n" +
                "import javafx.scene.Scene;\n" +
                "import javafx.scene.control.Button;\n" +
                "import javafx.scene.layout.Pane;\n" +
                "import javafx.stage.Stage;\n" +
                "import javafx.stage.StageStyle; // AJOUT\n" +
                "import javafx.scene.paint.Color; // AJOUT\n" +
                "import javafx.scene.layout.Background; // AJOUT\n" +
                "\n" +
                "public class Main extends Application {\n" +
                "\n" +
                "    @Override\n" +
                "    public void start(Stage primaryStage) {\n" +
                "        // === Création des cocktails ===\n" +
                "        CocktailAlcool b1 = new CocktailAlcool(\"Mojito\", 8.0, 12.5, 8);\n" +
                "        CocktailAlcool b2 = new CocktailAlcool(\"Martini\", 14.99, 10.0, 10);\n" +
                "        CocktailSansAlcool c1 = new CocktailSansAlcool(\"Virgin Mojito\", 6.5, \"Fruitée\");\n" +
                "        CocktailSansAlcool c2 = new CocktailSansAlcool(\"Smoothie Fraise\", 5.0, \"Sucré\");\n" +
                "        CocktailSansAlcool c3 = new CocktailSansAlcool(\"Eau pétillante\", 2.0, \"SansSucre\");\n" +
                "        CocktailSansAlcool c4 = new CocktailSansAlcool(\"Orangina\", 1.99, \"Sucré\");\n" +
                "\n" +
                "        // === Création du bar ===\n" +
                "        Bar bar = new Bar();\n" +
                "\n" +
                "        // Ajout au stock avec quantités\n" +
                "        bar.getStock().ajouter(b1, 10);\n" +
                "        bar.getStock().ajouter(b2, 5);\n" +
                "        bar.getStock().ajouter(c1, 8);\n" +
                "        bar.getStock().ajouter(c2, 12);\n" +
                "        bar.getStock().ajouter(c3, 20);\n" +
                "        bar.getStock().ajouter(c4, 15);\n" +
                "\n" +
                "        // === Fenêtre JavaFX ===\n" +
                "        Pane root = new Pane();\n" +
                "\n" +
                "        // AJOUT : rendre le fond du layout transparent\n" +
                "        root.setBackground(Background.EMPTY);\n" +
                "\n" +
                "        // Bouton pour afficher le stock\n" +
                "        Button stockBtn = new Button(\"Afficher le stock\");\n" +
                "        stockBtn.setLayoutX(50);\n" +
                "        stockBtn.setLayoutY(50);\n" +
                "        stockBtn.setOnAction(e -> {\n" +
                "            System.out.println(\"=== Stock du bar ===\");\n" +
                "            System.out.println(bar.getStock().afficher());\n" +
                "        });\n" +
                "\n" +
                "        // === Création des employés ===\n" +
                "        Barman barman = new Barman(\"Jean\", 1800.0, 50, 1.2, \"Oui\");\n" +
                "        Serveur serveur = new Serveur(\"Paul\", 1600.0, 10, 1.5, \"Oui\");\n" +
                "\n" +
                "        Button personnelBtn = new Button(\"Afficher le personnel et actions\");\n" +
                "        personnelBtn.setLayoutX(50);\n" +
                "        personnelBtn.setLayoutY(100);\n" +
                "        personnelBtn.setOnAction(e -> {\n" +
                "            System.out.println(\"\\n=== Personnel du bar ===\");\n" +
                "            System.out.println(barman.afficher());\n" +
                "            System.out.println(serveur.afficher());\n" +
                "\n" +
                "            System.out.println(\"\\n=== Actions du personnel ===\");\n" +
                "            System.out.println(barman.preparerCocktail(b1));\n" +
                "            System.out.println(serveur.afficher());\n" +
                "        });\n" +
                "\n" +
                "        // === Création des clients et commandes ===\n" +
                "        Client client1 = new Client(\"Alice\", 50.0);\n" +
                "        Commande cmd1 = new Commande(client1);\n" +
                "        cmd1.ajouterCocktail(b1, bar.getStock());\n" +
                "        cmd1.ajouterCocktail(c1, bar.getStock());\n" +
                "\n" +
                "        Client client2 = new Client(\"Bob\", 30.0);\n" +
                "        Commande cmd2 = new Commande(client2);\n" +
                "        cmd2.ajouterCocktail(b2, bar.getStock());\n" +
                "        cmd2.ajouterCocktail(c2, bar.getStock());\n" +
                "\n" +
                "        Button commandesBtn = new Button(\"Afficher commandes et paiements\");\n" +
                "        commandesBtn.setLayoutX(50);\n" +
                "        commandesBtn.setLayoutY(150);\n" +
                "        commandesBtn.setOnAction(e -> {\n" +
                "            System.out.println(\"\\n=== Commande du client Alice ===\");\n" +
                "            System.out.println(cmd1.afficherCommande());\n" +
                "\n" +
                "            System.out.println(\"\\n=== Commande du client Bob ===\");\n" +
                "            System.out.println(cmd2.afficherCommande());\n" +
                "\n" +
                "            // Paiement des commandes\n" +
                "            System.out.println(\"\\n=== Paiement Alice ===\");\n" +
                "            cmd1.payer();\n" +
                "            System.out.println(\"\\n=== Paiement Bob ===\");\n" +
                "            cmd2.payer();\n" +
                "\n" +
                "            // Enregistrement des commandes dans le bar\n" +
                "            bar.ajouterCommande(cmd1);\n" +
                "            bar.ajouterCommande(cmd2);\n" +
                "\n" +
                "            // Affichage des commandes enregistrées\n" +
                "            System.out.println(\"\\n=== Commandes enregistrées au bar ===\");\n" +
                "            System.out.println(bar.afficherCommandes());\n" +
                "        });\n" +
                "\n" +
                "        root.getChildren().addAll(stockBtn, personnelBtn, commandesBtn);\n" +
                "\n" +
                "        Scene scene = new Scene(root, 800, 600);\n" +
                "        scene.getStylesheets().add(getClass().getResource(\"/style.css\").toExternalForm());\n" +
                "\n" +
                "        // AJOUT : rendre la scène transparente\n" +
                "        scene.setFill(Color.TRANSPARENT);\n" +
                "\n" +
                "        // AJOUT : rendre la fenêtre transparente\n" +
                "        primaryStage.initStyle(StageStyle.TRANSPARENT);\n" +
                "\n" +
                "        primaryStage.setTitle(\"Jeu de cocktails\");\n" +
                "        primaryStage.setScene(scene);\n" +
                "        primaryStage.show();\n" +
                "    }\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        launch(args); // lance JavaFX\n" +
                "    }\n" +
                "}eu de cocktails");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // lance JavaFX
    }
}

