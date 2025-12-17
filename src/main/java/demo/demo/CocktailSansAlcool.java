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
}