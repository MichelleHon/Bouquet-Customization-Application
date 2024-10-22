package model;

// Represents a flower or greenary that would be added to the bouquet
public class Flower {
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
}
