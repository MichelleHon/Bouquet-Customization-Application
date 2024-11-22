package ui;

import java.io.FileNotFoundException;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

// Bouquet customization application's main window frame
public class BouquetCustomizationAppGUI extends JFrame {

    // EFFECTS: sets up bouquet, json reader and writer, and main panel screen
    // code source from LabelChanger, SmartHome and AlarmController
    public BouquetCustomizationAppGUI() throws FileNotFoundException {
        //stub
    }

    // EFFECTS: returns a message that contains the given text and uses the given font size
    private JLabel status(String text, int fontSize) {
        JLabel stubLabel = new JLabel();
        return stubLabel; //stub
    }

    // EFFECTS: returns a thank you message  
    private JLabel thank() {
        JLabel stubLabel = new JLabel();
        return stubLabel; //stub
    }

    // REQUIRES: action != null
    // EFFECTS: returns a button that contains the given text, changes color when mouse hovers over
    //          and performs the given action when pressed
    private JButton hover(String text, Color color, Color hover, ActionListener e) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to load a previously saved bouquet when pressed
    private JButton loadBtn() {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to create a new bouquet when pressed
    private JButton newBtn() {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to proceed to the menu screen when pressed
    private JButton continueBtn() {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to return to the menu screen when pressed
    private JButton returnBtn() {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // REQUIRES: flower != null
    // EFFECTS: returns a button that directs users to the add flower panel when pressed
    private JButton addFlowerBtn(FlowerUI flower) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // REQUIRES: flower != null
    // EFFECTS: returns a button that directs users to the remove flower panel when pressed
    private JButton removeFlowerBtn(FlowerUI flower) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that directs users to the view bouquet requirements list panel when pressed
    private JButton viewBouquetBtn() {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that directs users to the popular bouquets panel when pressed
    private JButton popularBouquetsBtn() {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that brings users to the saving bouquet screen when pressed
    private JButton quitAppBtn() {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that saves the users bouquet requirements list to file 
    //          and then closes the application when pressed
    private JButton saveBtn() {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that closes the application when pressed
    private JButton quitBtn() {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // MODIFIES: this
    // EFFECTS: sets up the home panel and adds a greeting message, load and new bouquet buttons and a gif to the panel
    private JPanel homeScreen() {
        JPanel stubPanel = new JPanel();
        return stubPanel; //stub
    }

    // MODIFIES: this
    // EFFECTS: sets up the gif in a container to be added to the home screen
    private JPanel gifPanel() {
        JPanel stubPanel = new JPanel();
        return stubPanel; //stub
    }

    // MODIFIES: this
    // EFFECTS: sets up a menu panel and adds a call to action message and the actions button panel
    private JPanel runCustomization() {
        JPanel stubPanel = new JPanel();
        return stubPanel; //stub
    }

    // MODIFIES: this
    // EFFECTS: sets up a actions button panel and adds five buttons:
    //          addFlowerBtn, removeFlowerBtn, viewBouquetBtn, popularBouquetsBtn, quitAppBtn
    private JPanel buttonPanel() {
        JPanel stubPanel = new JPanel();
        return stubPanel; //stub
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file and displays a status message about the loading state
    private void loadBouquet() {
        //stub
    }

    // EFFECTS: saves the workroom to file and displays a status message about the loading state
    private void saveBouquet() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: sets up a quit application panel and adds save and quit buttons 
    //          and a sample bouquet photo with description
    private void quitScreen() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: sets up a quit application panel and adds save and quit buttons 
    //          and a sample bouquet photo with description
    private JPanel endPhoto() {
        JPanel stubPanel = new JPanel();
        return stubPanel; //stub
    }
}