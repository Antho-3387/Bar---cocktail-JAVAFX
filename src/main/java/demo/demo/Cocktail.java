package demo.demo;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Cocktail {
    private String nom;
    private double prix;
    private double prixOriginal;
    private List<String> etapesPreparation;
    private List<String> ingredientsRequis = new ArrayList<>();

    // --- Constructeurs ---
    public Cocktail(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        this.prixOriginal = prix;
        this.etapesPreparation = List.of(); // vide par défaut
    }

    public Cocktail(String nom, double prix, List<String> etapesPreparation) {
        this.nom = nom;
        this.prix = prix;
        this.prixOriginal = prix;
        this.etapesPreparation = etapesPreparation;
    }

    // --- Getters & Setters ---
    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public double getPrixOriginal() { return prixOriginal; }
    public void setPrix(double nouveauPrix) { this.prix = nouveauPrix; }

    public List<String> getEtapesPreparation() { return etapesPreparation; }
    public void setEtapesPreparation(List<String> etapesPreparation) {
        this.etapesPreparation = etapesPreparation != null ? new ArrayList<>(etapesPreparation) : List.of();
    }

    public List<String> getIngredientsRequis() { return ingredientsRequis; }
    public void setIngredientsRequis(List<String> ingredients) {
        this.ingredientsRequis = ingredients != null ? new ArrayList<>(ingredients) : new ArrayList<>();
    }

    // --- Méthodes utilitaires ---
    public void appliquerReduction(double pourcentage) {
        this.prix = prix * (1 - pourcentage);
    }

    public void remettrePrixOriginal() {
        this.prix = prixOriginal;
    }

    // --- Méthodes d'affichage ---
    public String preparer() {
        StringBuilder sb = new StringBuilder("Préparation du cocktail : " + nom + "\n");
        for (String etape : etapesPreparation) {
            sb.append("- ").append(etape).append("\n");
        }
        return sb.toString();
    }

    public String afficher() {
        return "Cocktail: " + nom + " | Prix: " + prix + " €\n";
    }

    @Override
    public String toString() {
        return nom + " - " + prix + " €";
    }

    // --- Égalité & HashCode ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cocktail)) return false;
        Cocktail other = (Cocktail) o;
        return Objects.equals(nom, other.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}