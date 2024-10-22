package model;

import java.util.ArrayList;

// Represents a bouquet having a customer name, the list of requirements and the price (in dollars)
public class Bouquet {
    private String name; // customer name
    private double price; // current price of bouquet
    private ArrayList<Flower> flowerNames; // list of flower names for bouquet requirements

    // EFFECTS: name is set to customerName, input of flowerNames is set to
    // flowerNames for this Bouquet
    // and price is set to zero
    public Bouquet(String customerName, ArrayList<Flower> flowerNames, double bouquetPrice) {
        this.name = customerName;
        this.price = bouquetPrice;
        this.flowerNames = flowerNames;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // MODIFIES: this
    // EFFECTS: adds a flower to the collection of requirements for the bouquet
    public void flowerAdd(Flower flower) {
        flowerNames.add(flower);
    }

    // MOFIDIES: this
    // EFFECTS: removes a flower from the collection of requirements for the bouquet
    public void flowerRemove(Flower flower) {
        flowerNames.remove(flower);

    }

    // EFFECTS: returns the list of requirements
    // the user has inputted for the bouquet,
    // the list displayed could be empty (it is never null)
    public ArrayList<Flower> getBouquetRequirements() {
        return flowerNames;
    }

    // EFFECTS: add the requirement of PopularBouquetOne from PopularBouquets class
    // to list of requirements in Bouquet
    // this is done so users can add and or remove flowers for further
    // customization of their bouquet
    public void addPopBouquetOne() {
    }

    // EFFECTS: add the requirement of PopularBouquetTwo from PopularBouquets class
    // to list of requirements in Bouquet
    // this is done so users can add and or remove flowers for further
    // customization of their bouquet
    public void addPopBouquetTwo() {
    }

    // EFFECTS: add the requirement of PopularBouquetThree from PopularBouquets
    // class
    // to list of requirements in Bouquet
    // this is done so users can add and or remove flowers for further
    // customization of their bouquet
    public void addPopBouquetThree() {
    }
}
