package demo.demo;

import java.util.ArrayList;

public class Bar {
    private Stock stock = new Stock();
    private ArrayList<Commande> commandes = new ArrayList<>();

    public Stock getStock() { return stock; }

    public void ajouterCommande(Commande cmd) {
        commandes.add(cmd);
    }

    public String afficherCommandes() {
        StringBuilder sb = new StringBuilder();
        for (Commande cmd : commandes) {
            sb.append(cmd.afficherCommande()).append("\n");
        }
        return sb.toString();
    }
}

