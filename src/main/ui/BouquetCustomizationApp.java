package ui;

import java.util.Scanner;

import model.Bouquet;

// Bouquet customization applicaation
public class BouquetCustomizationApp {
    private Scanner scanner;
    private Bouquet bouquet = new Bouquet(null, 0);


    // EFFECTS: runs the customization application
    public BouquetCustomizationApp(){
        runCustomization();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runCustomization(){
        boolean runCus = true;
        String input = null;

        scanner = new Scanner(System.in);

        while(runCus) {
            displayMenu(); 
            input = scanner.next();
            input = input.toLowerCase();

            if (input.equals("q")) {
                runCus = false;
            } else if (input.equals("a")) {
                addFlower();
            } else if (input.equals("r")) {
                removeFlower();
            } else if (input.equals("v")) {
                bouquet.bouquetRequirements();
                System.out.println(bouquet.bouquetRequirements());
            } else if (input.equals("s")) {
                popularBouquets();
            } else {
                System.out.println("Selection invalid");
            }
        }    
        System.out.println("\nGoodbye");

    }

    // EFFECTS: displays menu of options to user
    private void displayMenu(){
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add flower");
        System.out.println("\tr -> remove flower");
        System.out.println("\tv -> view bouquet requirements");
        System.out.println("\ts -> select from popular bouquets");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: instructs user to type in a flower name to add to the bouquet
    private void addFlower() {
        System.out.println("Enter a flower to add to the bouquet: ");
        String flowerInput = scanner.next();
        flowerInput = flowerInput.toLowerCase();
        bouquet.aFlower(flowerInput);
    }

    // MODIFIES: this
    // EFFECTS: instructs user to type in a flower name to remove from the bouquet
    private void removeFlower() {
        System.out.println("Enter a flower to remove from the bouquet: ");
        String flowerInput = scanner.next();
        flowerInput = flowerInput.toLowerCase();
        bouquet.rFlower(flowerInput);
    }

    // MODIFIES: this
    // EFFECTS: processes user input regarding popular bouquet
    private void popularBouquets() {
        popBouquetMenu();

        String popInput = scanner.next();
        //popInput = popInput.toLowerCase();

        if (popInput.equals("1")) {
            bouquet.popularBouquetOne();
        } else if (popInput.equals("2")) {
            bouquet.popularBouquetTwo();
        } else if (popInput.equals("3")) {
            bouquet.popularBouquetThree();
        } else {
            System.out.println("Selection invalid");
        }
    }

    // EFFECTS: displays menu of popular bouquet options to user
    private void popBouquetMenu(){
        System.out.println("Here are our top 3 bouquets");
        System.out.println("You may choose them as a base and customize further");
        System.out.println("\t1: Classic Garden Rose($80)");
        System.out.println("\t2: Sunshine Delight($105)");
        System.out.println("\t3: Spring Elegance($130)");
    }
}
