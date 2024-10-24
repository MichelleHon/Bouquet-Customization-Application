package model;

import org.json.JSONObject;

import persistence.Writable;

// Represents a flower or greenary that would be added to the bouquet
public class Flower implements Writable {
    private String flowerName; // flower name

    // EFFECTS: input of flowerName is set to flowerName for this Flower
    public Flower(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getFlowerName() {
        return flowerName;
    }

    // EFFECTS: returns a string representation of Flower
    // code source from TellerApp (with exceptions)
    @Override
    public String toString() {
        return flowerName;
    }

    // EFFECTS: returns this flower as a JSON object
    // code source from JsonSerializationDemo
    @Override
    public JSONObject toJson() {
        return new JSONObject(); //stub
    }
}
