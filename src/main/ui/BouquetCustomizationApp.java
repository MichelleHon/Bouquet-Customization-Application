package ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import model.Bouquet;
import model.Flower;

import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

// Bouquet customization applicaation
public class BouquetCustomizationApp {
    private Scanner scanner;
    private Bouquet bouquet;
    private static final String BOUTIQUE = "./data/boutique.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the customization application
    public BouquetCustomizationApp() throws FileNotFoundException {
        bouquet = new Bouquet("Customer1", new ArrayList<>(), 0);
        jsonWriter = new JsonWriter(BOUTIQUE);
        jsonReader = new JsonReader(BOUTIQUE);
        runCustomization();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // code source from TellerApp
    private void runCustomization() {
        boolean runCus = true;
        String input = null;

        scanner = new Scanner(System.in);

        while (runCus) {
            displayMenu();
            input = scanner.next();
            input = input.toLowerCase();

            if (input.equals("q")) {
                runCus = false;
            } else {
                processCommand(input);
            }
        }
        System.out.println("Goodbye");

    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String input) {
        if (input.equals("a")) {
            addFlower();
        } else if (input.equals("r")) {
            removeFlower();
        } else if (input.equals("v")) {
            bouquet.getBouquetRequirements();
            System.out.println(bouquet.getBouquetRequirements());
        } else if (input.equals("s")) {
            popularBouquets();
        } else if (input.equals("sv")) {
            saveBouquet();
        } else {
            System.out.println("Selection invalid");
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add flower");
        System.out.println("\tr -> remove flower");
        System.out.println("\tv -> view bouquet requirements");
        System.out.println("\ts -> select from popular bouquets");
        System.out.println("\tsv -> save bouquet to file");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: instructs user to type in a flower name to add to the bouquet
    private void addFlower() {
        System.out.println("Enter a flower to add to the bouquet: ");
        String flowerInput = scanner.next();
        Flower addFlower = new Flower(flowerInput);
        bouquet.flowerAdd(addFlower);
    }

    // MODIFIES: this
    // EFFECTS: instructs user to type in a flower name to remove from the bouquet
    // and checks if flower is in list of requirements
    // if it is, it will call for a method to remove the flower
    // otherwise print a statement telling user that flower is not in bouquet
    private void removeFlower() {
        System.out.println("Enter a flower to remove from the bouquet: ");
        String flowerInput = scanner.next();
        Iterator<Flower> iterator = bouquet.getBouquetRequirements().iterator();
        boolean flowerFound = false;

        while (iterator.hasNext()) {
            Flower currentFlower = iterator.next();
            if (currentFlower.getFlowerName().equalsIgnoreCase(flowerInput)) {
                bouquet.flowerRemove(currentFlower);
                flowerFound = true;
                break;
            }
        }
        if (!flowerFound) {
            System.out.println("Flower not in bouquet");
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user input regarding popular bouquet
    private void popularBouquets() {
        popBouquetMenu();

        String popInput = scanner.next();

        if (popInput.equals("1")) {
            bouquet.addPopBouquetOne();
        } else if (popInput.equals("2")) {
            bouquet.addPopBouquetTwo();
        } else if (popInput.equals("3")) {
            bouquet.addPopBouquetThree();
        } else {
            System.out.println("Selection invalid");
        }
    }

    // EFFECTS: displays menu of popular bouquet options to user
    private void popBouquetMenu() {
        System.out.println("Here are our top 3 bouquets");
        System.out.println("You may choose them as a base and customize further");
        System.out.println("\t1: Classic Garden Rose($80)");
        System.out.println("\t2: Sunshine Delight($105)");
        System.out.println("\t3: Spring Elegance($130)");
    }

    // EFFECTS: saves the Bouquet to file
    // code source from JsonSerializationDemo
    private void saveBouquet() {
        try {
            jsonWriter.open();
            jsonWriter.write(bouquet);
            jsonWriter.close();
            System.out.println("Saved " + bouquet.getName() + " to " + BOUTIQUE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + BOUTIQUE);
        }
    }
}
