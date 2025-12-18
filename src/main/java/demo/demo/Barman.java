package demo.demo;

public class Barman extends Employe {
    private double nombreVerres;
    private double vitesse;
    private String disponibilite;

    // Constructeur : fixe automatiquement le rôle "Barman"
    public Barman(String nom, double salaire, double nombreVerres, double vitesse, String disponibilite) {
        super(nom, "Barman", salaire);
        this.nombreVerres = nombreVerres;
        this.vitesse = vitesse;
        this.disponibilite = disponibilite;
    }

    @Override
    public String afficher() {
        return super.afficher() +
                "Nombre de Verres préparés: " + nombreVerres +
                " | Vitesse: " + vitesse +
                " | Disponible ? " + disponibilite + "\n";
    }

    public String preparerCocktail(Cocktail c) {
        nombreVerres++;
        return getNom() + " prépare le cocktail :\n" + c.preparer();
    }
}