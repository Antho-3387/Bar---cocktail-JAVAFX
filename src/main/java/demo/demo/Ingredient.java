package demo.demo;

public class Ingredient {
    private String nom;
    private int quantite;
    private String type;

    public Ingredient(String nom, int quantite, String type) {
        this.nom = nom;
        this.quantite = quantite;
        this.type = type;
    }

    public String getNom() { return nom; }
    public int getQuantite() { return quantite; }
    public String getType() { return type; }

    public void retirer(int qte) {
        this.quantite = Math.max(0, quantite - qte);
    }

    public void ajouter(int qte) {
        this.quantite += qte;
    }

    @Override
    public String toString() {
        return nom + " (" + quantite + " dispo)";
    }
}