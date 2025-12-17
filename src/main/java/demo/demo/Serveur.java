package demo.demo;

public class Serveur extends Employe {
    private double nombreTables;
    private double vitesse;
    private String disponibilite;

    // Constructeur : fixe automatiquement le rôle "Serveur"
    public Serveur(String nom, double salaire, double nombreTables, double vitesse, String disponibilite) {
        super(nom, "Serveur", salaire); // rôle fixé
        this.nombreTables = nombreTables;
        this.vitesse = vitesse;
        this.disponibilite = disponibilite;
    }

    @Override
    public String afficher() {
        return super.afficher() +
                "Nombre de tables: " + nombreTables +
                " | Vitesse: " + vitesse +
                " | Disponible ? " + disponibilite + "\n";
    }
}