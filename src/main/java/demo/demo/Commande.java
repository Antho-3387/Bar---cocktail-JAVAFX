package demo.demo;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private Client client;
    private List<Cocktail> cocktails = new ArrayList<>();
    private boolean payee = false;

    public Commande(Client client) { this.client = client; }

    public boolean ajouterCocktail(Cocktail c, Stock stock) {
        if (stock.consommer(c)) {
            cocktails.add(c);
            return true;
        }
        return false;
    }

    public double prixTotal() {
        double total = 0;
        for (Cocktail c : cocktails) total += c.getPrix();
        return total;
    }

    public boolean payer() {
        if (payee) return false;
        double total = prixTotal();
        if (client.getSolde() >= total) {
            client.debiter(total);
            payee = true;
            return true;
        }
        return false;
    }

    public boolean estPayee() { return payee; }

    public void vider() { cocktails.clear(); }

    public String afficherCommande() {
        StringBuilder sb = new StringBuilder();
        sb.append("Commande du client: ").append(client.getNom()).append("\n");
        for (Cocktail c : cocktails) sb.append(c.afficher());
        sb.append("Prix total: ").append(prixTotal())
                .append(" € | Payée ? ").append(payee ? "Oui" : "Non")
                .append("\n");
        return sb.toString();
    }
}