package model;

import java.util.ArrayList;

// Represents lists of popular bouquets
public class PopularBouquets {
    private ArrayList<Flower> popularBouquets;

    // EFFECTS: popularBouquets is set to a new ArrayList
    public PopularBouquets() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 1
    public Bouquet setPopularBouquetOne() {
        return new Bouquet(null, null, 0); //stub
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 2
    public Bouquet setPopularBouquetTwo() {
        return new Bouquet(null, null, 0); //stub
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 3
    public Bouquet setPopularBouquetThree() {
        return new Bouquet(null, null, 0); //stub
    }
}
