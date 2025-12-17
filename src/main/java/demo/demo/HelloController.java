package demo.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HelloController {

    @FXML private TextArea outputArea;

    private Bar bar;
    private Client client;
    private Commande commande;
    private Barman barman;
    private Serveur serveur;

    @FXML
    public void initialize() {
        bar = new Bar();
        client = new Client("Alice", 350.0);
        commande = new Commande(client);

        // Initialisation du stock
        bar.getStock().ajouter(new CocktailAlcool("Mojito", 8.0, 12.5, 8), 20);
        bar.getStock().ajouter(new CocktailAlcool("Martini", 14.99, 10.0, 10), 10);
        bar.getStock().ajouter(new CocktailAlcool("Cosmopolitan", 12.5, 8.0, 12), 10);
        bar.getStock().ajouter(new CocktailAlcool("Blue Lagoon", 10.5, 9.0, 15), 10);
        bar.getStock().ajouter(new CocktailSansAlcool("Orangina", 1.99, "Sucré"), 20);
        bar.getStock().ajouter(new CocktailSansAlcool("Cola", 2.5, "Sucré"), 20);
        bar.getStock().ajouter(new CocktailSansAlcool("Sprite", 2.0, "SansSucre"), 20);

        barman = new Barman("Jean", 1800.0, 50, 1.2, "Oui");
        serveur = new Serveur("Paul", 1600.0, 10, 1.5, "Oui");

        outputArea.appendText("Bar initialisé avec cocktails et boissons sans alcool.\n");
    }

    // Méthodes pour chaque bouton Ajouter
    @FXML protected void ajouterMojito() { ajouterCocktail(new CocktailAlcool("Mojito", 8.0, 12.5, 8)); }
    @FXML protected void ajouterMartini() { ajouterCocktail(new CocktailAlcool("Martini", 14.99, 10.0, 10)); }
    @FXML protected void ajouterCosmopolitan() { ajouterCocktail(new CocktailAlcool("Cosmopolitan", 12.5, 8.0, 12)); }
    @FXML protected void ajouterBlueLagoon() { ajouterCocktail(new CocktailAlcool("Blue Lagoon", 10.5, 9.0, 15)); }
    @FXML protected void ajouterOrangina() { ajouterCocktail(new CocktailSansAlcool("Orangina", 1.99, "Sucré")); }
    @FXML protected void ajouterCola() { ajouterCocktail(new CocktailSansAlcool("Cola", 2.5, "Sucré")); }
    @FXML protected void ajouterSprite() { ajouterCocktail(new CocktailSansAlcool("Sprite", 2.0, "SansSucre")); }

    private void ajouterCocktail(Cocktail c) {
        if (commande.ajouterCocktail(c, bar.getStock())) {
            outputArea.appendText(c.getNom() + " ajouté à la commande.\n");
        } else {
            outputArea.appendText("Stock épuisé pour " + c.getNom() + " !\n");
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
        outputArea.appendText(bar.getStock().remplirStock());
    }
}