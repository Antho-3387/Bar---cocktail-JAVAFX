package demo.demo;
import java.util.Objects;

public class Cocktail {
    private String nom;
    private double prix;
    private double prixOriginal;

    public Cocktail(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        this.prixOriginal = prix;
    }

    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public double getPrixOriginal() { return prixOriginal; }
    public void setPrix(double nouveauPrix) { this.prix = nouveauPrix; }

    public void appliquerReduction(double pourcentage) { this.prix = prix * (1 - pourcentage); }
    public void remettrePrixOriginal() { this.prix = prixOriginal; }

    public String afficher() { return "Cocktail: " + nom + " | Prix: " + prix + " €\n"; }

    @Override
    public String toString() { return nom + " - " + prix + " €"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cocktail)) return false;
        Cocktail other = (Cocktail) o;
        return Objects.equals(nom, other.nom);
    }

    @Override
    public int hashCode() { return Objects.hash(nom); }
}