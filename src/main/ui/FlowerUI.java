package ui;

import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Bouquet;
import model.Flower;

// Bouquet customization application's add and remove window frame
public class FlowerUI extends JPanel {

    // EFFECTS: returns a message that contains the given text and uses the given font size
    private JLabel status(String text, int fontSize) {
        JLabel stubLabel = new JLabel();
        return stubLabel; //stub
    }

    // EFFECTS: returns a message that prompts users to add a flower to their bouquet
    private JLabel addFlowerPrompt() {
        JLabel stubLabel = new JLabel();
        return stubLabel; //stub
    }

    // EFFECTS: returns a message that prompts users to remove a flower from their bouquet
    private JLabel removeFlowerPrompt() {
        JLabel stubLabel = new JLabel();
        return stubLabel; //stub
    }

    // EFFECTS: sets up a text field that allows users to type the flower name they would like to add or remove
    private JTextField textField() {
        JTextField stubTextField = new JTextField();
        return stubTextField; //stub
    }
    
    // EFFECTS: returns a button that contains the given text, changes color when mouse hovers over
    //          and performs the given action when pressed
    private JButton hover(String text, Color color, Color hover, ActionListener e) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to add a flower to their bouquet requirements list when pressed
    private JButton addFlowerButton(JTextField textField, Bouquet bouquet) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to return to the menu screen when pressed
    private JButton returnBtn(BouquetCustomizationAppGUI mainPanel) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to remove a flower from their bouquet requirements list when pressed
    private JButton removeFlowerButton(JTextField textField, Bouquet bouquet) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // MODIFIES: this
    // EFFECTS: sets up the add flower panel 
    //          and adds a text field, status, message prompt, add flower and return buttons
    public JPanel addFlower(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        JPanel stubPanel = new JPanel();
        return stubPanel; //stub
    }

    // MODIFIES: this
    // EFFECTS: adds given flower name to bouquet requirements list 
    private void addFlowerToBouquet(JTextField flowerName, Bouquet bouquet) {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: sets up the remove flower panel 
    //          and adds a text field, status, message prompt, remove flower and return buttons
    public JPanel removeFlower(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        JPanel stubPanel = new JPanel();
        return stubPanel; //stub
    }

    // MODIFIES: this
    // EFFECTS: takes the given flower name and checks if it is in the bouquet
    //          removes the flower if the given flower name is in the bouquet
    //          otherwise displays a error message
    private void removeFlowerFromBouquet(JTextField flowerName, Bouquet bouquet) {
        //stub
    }
}
