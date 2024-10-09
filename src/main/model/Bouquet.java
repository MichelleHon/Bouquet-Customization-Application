package model;

import java.util.List;
import java.util.ArrayList;

// Represents a bouquet having a customer name and price (in dollars)
public class Bouquet {
    private String name;  // customer name
    private double price; // current price of bouquet
    private List<String> flowerNames = new ArrayList<>(); // flower names for bouquet requirements

    // EFFECTS: name is set to customerName, price is set to zero
    public Bouquet(String customerName, double bouquetPrice) {
        //stub
    }

    public String getName(){
        return ""; 
    }

    public double getPrice(){
        return 0; 
    }

    // MODIFIES: this
    // EFFECTS: adds a flower to the collection of requirements for the bouquet
    public void aFlower(String flower){
        //stub
    }

    // MOFIDIES: this
    // EFFECTS: removes a flower from the collection of requirements 
    // for the bouquet
    public void rFlower(String flower){
        //stub
    }

    // EFFECTS: returns the list of requirements 
    // the user has inputted for the bouquet, 
    // the list displayed could be empty (it is never null)
    public List<String> bouquetRequirements() {
        return new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 1
    public void popularBouquetOne() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 2
    public void popularBouquetTwo() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: add all flowers for popular bouquet 3
    public void popularBouquetThree() {
        //stub
    }
}
