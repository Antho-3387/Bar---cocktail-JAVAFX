package demo.demo;

public class Client {
    private String nom;
    private double solde;

    public Client(String nom, double solde) {
        this.nom = nom;
        this.solde = solde;
    }

    public String getNom() { return nom; }
    public double getSolde() { return solde; }

    public void debiter(double montant) {
        solde -= montant;
    }
}