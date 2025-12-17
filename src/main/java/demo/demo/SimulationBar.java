package demo.demo;

import java.util.ArrayList;
import java.util.List;

public class SimulationBar {

    public static void main(String[] args) {
        // Liste des jours
        List<String> jours = new ArrayList<>();
        jours.add("Lundi");
        jours.add("Mardi");
        jours.add("Mercredi");
        jours.add("Jeudi");
        jours.add("Vendredi");
        jours.add("Samedi");
        jours.add("Dimanche");

        // Exemple de cocktails (ici tableau vide, à remplir avec tes objets Cocktail)
        Cocktail[] listeCocktail = {};

        int nbrJour = jours.size();
        int nbr = 0;
        boolean hh = false;

        while (nbr < nbrJour) {
            String temps = "Jour";
            System.out.println("On est " + jours.get(nbr) + " pendant la journée.");
            // Ici tu pourrais simuler la prise de commandes

            temps = "Nuit";
            System.out.println("On est " + jours.get(nbr) + " pendant la nuit.");

            if (happyHour() && !hh && temps.equals("Nuit")) {
                hh = true;
                reduire(listeCocktail);
            }

            // Fin de journée → reset
            hh = false;
            remettreLesPrix(listeCocktail);
            nbr++;
        }
    }

    // HappyHour aléatoire
    private static boolean happyHour() {
        int randomNum = (int) (Math.random() * 4); // 0 à 3
        return randomNum == 0;
    }

    // Réduction des prix pendant HappyHour
    private static void reduire(Cocktail[] tbl) {
        for (Cocktail c : tbl) {
            c.setPrix(c.getPrix() * 0.75);
        }
    }

    // Remettre les prix originaux
    private static void remettreLesPrix(Cocktail[] tbl) {
        for (Cocktail c : tbl) {
            c.setPrix(c.getPrixOriginal());
        }
    }
}