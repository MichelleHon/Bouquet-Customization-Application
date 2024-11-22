package ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

import model.Bouquet;

// Bouquet customization application's viewing bouquet requirements list frame
public class BouquetUI extends JFrame {

    // EFFECTS: returns a button that contains the given text, changes color when mouse hovers over
    //          and performs the given action when pressed
    private JButton hover(String text, Color color, Color hover, ActionListener e) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to return to the menu screen when pressed
    private JButton returnBtn(BouquetCustomizationAppGUI mainPanel) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to remove all flowers from their bouquet list when pressed
    private JButton clearAllBtn(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a message that tells users the list they are viewing
    private JLabel viewFlowerPrompt() {
        JLabel stubLabel = new JLabel();
        return stubLabel; //stub
    }

    // EFFECTS: returns a message that contains the given text and uses the given font size
    private JLabel status(String text, int fontSize) {
        JLabel stubLabel = new JLabel();
        return stubLabel; //stub
    }

    // EFFECTS: sets up a text area that displays the list of flowers in users bouquet requirements list
    private JTextArea bouquetContents() {
        JTextArea stubTextArea = new JTextArea();
        return stubTextArea; //stub
    }

    // EFFECTS: sets up a scroll panel that in the text area
    private JScrollPane scrollPane(JTextArea textArea) {
        JScrollPane stubScrollPane = new JScrollPane();
        return stubScrollPane; //stub
    }

    // MODIFIES: this
    // EFFECTS: sets up view flowers in users bouquet requirements list panel 
    //          and adds a status label, text area, scroll panel and a clear all flowers from list button
    public JPanel viewBouquet(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        JPanel stubPanel = new JPanel();
        return stubPanel; //stub
    }
}
