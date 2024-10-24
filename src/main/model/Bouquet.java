package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

// Represents a bouquet having a customer name, the list of requirements and the price (in dollars)
public class Bouquet implements Writable {
    private String name; // customer name
    private int price; // current price of bouquet
    private ArrayList<Flower> flowerNames; // list of flower names for bouquet requirements

    // EFFECTS: name is set to customerName, input of flowerNames is set to
    // flowerNames for this Bouquet
    // and price is set to zero
    public Bouquet(String customerName, ArrayList<Flower> flowerNames, int bouquetPrice) {
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
        PopularBouquets popularBouquets = new PopularBouquets();
        Bouquet popBouquetOne = popularBouquets.setPopularBouquetOne();
        flowerNames.addAll(popBouquetOne.getBouquetRequirements());
    }

    // EFFECTS: add the requirement of PopularBouquetTwo from PopularBouquets class
    // to list of requirements in Bouquet
    // this is done so users can add and or remove flowers for further
    // customization of their bouquet
    public void addPopBouquetTwo() {
        PopularBouquets popularBouquets = new PopularBouquets();
        Bouquet popBouquetTwo = popularBouquets.setPopularBouquetTwo();
        flowerNames.addAll(popBouquetTwo.getBouquetRequirements());
    }

    // EFFECTS: add the requirement of PopularBouquetThree from PopularBouquets
    // class
    // to list of requirements in Bouquet
    // this is done so users can add and or remove flowers for further
    // customization of their bouquet
    public void addPopBouquetThree() {
        PopularBouquets popularBouquets = new PopularBouquets();
        Bouquet popBouquetThree = popularBouquets.setPopularBouquetThree();
        flowerNames.addAll(popBouquetThree.getBouquetRequirements());
    }

    // EFFECTS: returns this bouquet as a JSON object
    // code source from JsonSerializationDemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("CusName", name);
        json.put("flowers", flowersToJson());
        json.put("price", price);
        return json;
    }

    // EFFECTS: returns flowers in this bouquet as a JSON array
    // code source from JsonSerializationDemo
    private JSONArray flowersToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Flower f : flowerNames) {
            jsonArray.put(f.toJson());
        }
        return jsonArray;
    }
}
