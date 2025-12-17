package demo.demo;

public class Main {
    public static void main(String[] args) {
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

        // Affichage du stock
        System.out.println("=== Stock du bar ===");
        System.out.println(bar.getStock().afficher());

        // === Création des employés ===
        Barman barman = new Barman("Jean", 1800.0, 50, 1.2, "Oui");
        Serveur serveur = new Serveur("Paul", 1600.0, 10, 1.5, "Oui");

        System.out.println("\n=== Personnel du bar ===");
        System.out.println(barman.afficher());
        System.out.println(serveur.afficher());

        // === Création des clients et commandes ===
        Client client1 = new Client("Alice", 50.0); // solde de 50€
        Commande cmd1 = new Commande(client1);
        cmd1.ajouterCocktail(b1, bar.getStock());
        cmd1.ajouterCocktail(c1, bar.getStock());

        Client client2 = new Client("Bob", 30.0); // solde de 30€
        Commande cmd2 = new Commande(client2);
        cmd2.ajouterCocktail(b2, bar.getStock());
        cmd2.ajouterCocktail(c2, bar.getStock());

        // === Affichage des commandes ===
        System.out.println("\n=== Commande du client Alice ===");
        System.out.println(cmd1.afficherCommande());

        System.out.println("\n=== Commande du client Bob ===");
        System.out.println(cmd2.afficherCommande());

        // === Paiement des commandes ===
        System.out.println("\n=== Paiement Alice ===");
        cmd1.payer();

        System.out.println("\n=== Paiement Bob ===");
        cmd2.payer();

        // === Enregistrement des commandes dans le bar ===
        bar.ajouterCommande(cmd1);
        bar.ajouterCommande(cmd2);

        // === Affichage des commandes enregistrées ===
        System.out.println("\n=== Commandes enregistrées au bar ===");
        System.out.println(bar.afficherCommandes());

        // === Interaction du personnel ===
        System.out.println("\n=== Actions du personnel ===");
        System.out.println(barman.preparerCocktail(b1));
        System.out.println(serveur.afficher()); // le serveur pourrait être étendu pour "servir" une commande
    }
}