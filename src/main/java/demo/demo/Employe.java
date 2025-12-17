package demo.demo;

public class Employe {
    private String nom;
    private String role;
    private double salaire;

    public Employe(String nom, String role, double salaire) {
        this.nom = nom;
        this.role = role;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public String getRole() {
        return role;
    }

    public double getSalaire() {
        return salaire;
    }

    // Retourne une chaîne utilisable dans ton TextArea
    public String afficher() {
        return "Employé: " + nom + " | Rôle: " + role + " | Salaire: " + salaire + " €\n";
    }
}