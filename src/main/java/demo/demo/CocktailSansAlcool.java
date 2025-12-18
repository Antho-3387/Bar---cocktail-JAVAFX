package demo.demo;

public class CocktailSansAlcool extends Cocktail {
    private String gout;

    public CocktailSansAlcool(String nom, double prix, String gout) {
        super(nom, prix);
        this.gout = gout;
    }

    @Override
    public String afficher() {
        return "Cocktail sans alcool: " + getNom() + " | Prix: " + getPrix() +
                " € | Goût: " + gout + "\n";
    }

    @Override
    public String preparer() {
        return "🥤 Préparation du cocktail sans alcool : " + getNom() + "\n" +
                "- Goût : " + gout + "\n" +
                "- Ajouter les jus / sodas\n" +
                "- Mélanger\n" +
                "- Ajouter des glaçons\n" +
                "- Servir frais\n";
    }

}