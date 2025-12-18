package demo.demo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Stock {
    // Gestion des cocktails
    private Map<String, Cocktail> catalogue = new LinkedHashMap<>();
    private Map<String, Integer> quantites = new LinkedHashMap<>();
    private int capaciteMax = 20;

    // Gestion des ingrédients
    private Map<String, Ingredient> ingredients = new HashMap<>();

    // --- Gestion des cocktails ---
    public void ajouter(Cocktail c, int quantite) {
        String nom = c.getNom();
        catalogue.putIfAbsent(nom, c);
        quantites.put(nom, quantites.getOrDefault(nom, 0) + quantite);
    }

    public boolean consommer(Cocktail c) {
        String nom = c.getNom();
        int actuel = quantites.getOrDefault(nom, 0);
        if (actuel > 0) {
            quantites.put(nom, actuel - 1);
            return true;
        }
        return false;
    }

    public boolean disponible(Cocktail c) {
        return quantites.getOrDefault(c.getNom(), 0) > 0;
    }

    public String afficher() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Stock du bar ===\n");
        for (Map.Entry<String, Cocktail> e : catalogue.entrySet()) {
            String nom = e.getKey();
            int qte = quantites.getOrDefault(nom, 0);
            sb.append(nom).append(" : ").append(qte).append(" unités\n");
        }
        return sb.toString();
    }

    public String remplirStock() {
        StringBuilder sb = new StringBuilder();
        for (String nom : catalogue.keySet()) {
            int actuel = quantites.getOrDefault(nom, 0);
            if (actuel < capaciteMax) {
                quantites.put(nom, capaciteMax);
                sb.append("Stock de ").append(nom).append(" rempli à ")
                        .append(capaciteMax).append(" unités.\n");
            }
        }
        if (sb.length() == 0) sb.append("Tous les stocks sont déjà au maximum.\n");
        return sb.toString();
    }

    public Map<String, Cocktail> getCatalogue() {
        return catalogue;
    }

    // --- Gestion des ingrédients ---
    public void ajouterIngredient(Ingredient ingredient) {
        ingredients.put(ingredient.getNom(), ingredient);
    }

    public List<Ingredient> getTousLesIngredients() {
        return new ArrayList<>(ingredients.values());
    }
}