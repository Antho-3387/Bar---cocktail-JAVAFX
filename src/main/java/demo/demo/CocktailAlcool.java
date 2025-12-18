package demo.demo;

public class CocktailAlcool extends Cocktail {
    private double degreAlcool;
    private double volume;

    public CocktailAlcool(String nom, double prix, double degreAlcool, double volume) {
        super(nom, prix);
        this.degreAlcool = degreAlcool;
        this.volume = volume;
    }

    @Override
    public String afficher() {
        return "Cocktail alcoolisé: " + getNom() + " | Prix: " + getPrix() +
                " € | Degré: " + degreAlcool + "% | Volume: " + volume + "cl\n";
    }

    @Override
    public String preparer() {
        return "🍸 Préparation du cocktail alcoolisé : " + getNom() + "\n" +
                "- Mesurer " + volume + " cl\n" +
                "- Ajouter l'alcool (" + degreAlcool + "%)\n" +
                "- Ajouter les autres ingrédients\n" +
                "- Mélanger\n" +
                "- Servir\n";
    }


}