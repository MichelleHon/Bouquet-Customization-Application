package model;

import java.util.ArrayList;

// Represents lists of popular bouquets
public class PopularBouquets {
    private ArrayList<Flower> popularBouquets;

    // EFFECTS: popularBouquets is set to a new ArrayList
    public PopularBouquets() {
        this.popularBouquets = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 1
    public Bouquet setPopularBouquetOne() {

        for (int i = 0; i < 12; i++) {
            popularBouquets.add(new Flower("Rose"));
        }
        popularBouquets.add(new Flower("Greens"));

        return new Bouquet(null, popularBouquets, 80);
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 2
    public Bouquet setPopularBouquetTwo() {

        for (int i = 0; i < 3; i++) {
            popularBouquets.add(new Flower("Sunflower"));
            popularBouquets.add(new Flower("Daisy"));
            popularBouquets.add(new Flower("Lily"));
            popularBouquets.add(new Flower("Snowdrop"));
            popularBouquets.add(new Flower("Greens"));
        }
        popularBouquets.add(new Flower("Sunflower"));
        popularBouquets.add(new Flower("Daisy"));
        popularBouquets.add(new Flower("Daisy"));

        return new Bouquet(null, popularBouquets, 105);
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 3
    public Bouquet setPopularBouquetThree() {

        for (int i = 0; i < 3; i++) {
            popularBouquets.add(new Flower("Tulip"));
            popularBouquets.add(new Flower("Lavender"));
            popularBouquets.add(new Flower("Lilac"));
            popularBouquets.add(new Flower("Dahlias"));
            popularBouquets.add(new Flower("Bellflower"));
            popularBouquets.add(new Flower("Rosemary"));
        }
        popularBouquets.add(new Flower("Tulip"));
        popularBouquets.add(new Flower("Lavender"));
        popularBouquets.add(new Flower("Greens"));
        popularBouquets.add(new Flower("Greens"));

        return new Bouquet(null, popularBouquets, 130);
    }
}
