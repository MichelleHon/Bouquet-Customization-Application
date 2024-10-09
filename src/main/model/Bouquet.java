package model;

import java.util.ArrayList;

// Represents a bouquet having a customer name, price (in dollars) and the list of requirements
public class Bouquet {
    private String name;  // customer name
    private double price; // current price of bouquet
    private ArrayList<String> flowerNames = new ArrayList<>(); // flower names for bouquet requirements

    // EFFECTS: name is set to customerName, price is set to zero
    public Bouquet(String customerName, double bouquetPrice) {
        this.name = customerName;
        this.price = bouquetPrice;
    }

    public String getName() {
        return name; 
    }

    public double getPrice() {
        return price; 
    }

    // MODIFIES: this
    // EFFECTS: adds a flower to the collection of requirements for the bouquet
    public void flowerAdd(String flower) {
        flowerNames.add(flower);
    }

    // MOFIDIES: this
    // EFFECTS: removes a flower from the collection of requirements for the bouquet
    public void flowerRemove(String flower) {
        flowerNames.remove(flower);
        
    }

    // EFFECTS: returns the list of requirements 
    // the user has inputted for the bouquet, 
    // the list displayed could be empty (it is never null)
    public ArrayList<String> bouquetRequirements() {
        return flowerNames;
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 1
    public void popularBouquetOne() {
        for (int i = 0; i < 12; i++) {
            flowerNames.add("Rose");
        }
        flowerNames.add("Greens");
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 2
    public void popularBouquetTwo() {
        for (int i = 0; i < 3; i++) {
            flowerNames.add("Sunflower");
            flowerNames.add("Daisy");
            flowerNames.add("Lily");
            flowerNames.add("Snowdrop");
            flowerNames.add("Greens");
        }
        flowerNames.add("Sunflower");
        flowerNames.add("Daisy");
        flowerNames.add("Daisy");
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 3
    public void popularBouquetThree() {
        for (int i = 0; i < 3; i++) {
            flowerNames.add("Tulip");
            flowerNames.add("Lavender");
            flowerNames.add("Lilac");
            flowerNames.add("Dahlias");
            flowerNames.add("Bellflower");
            flowerNames.add("Rosemary");
        }
        flowerNames.add("Tulip");
        flowerNames.add("Lavender");
        flowerNames.add("Greens");
        flowerNames.add("Greens");
    }
}
