package ui;

import javax.swing.*;

import model.Bouquet;

import java.awt.*;
import java.awt.event.ActionListener;

// Bouquet customization application's popular bouquets window frame
public class PopularBouquetUI extends JPanel {

    // EFFECTS: returns a title for the popular bouquets panel
    private JLabel title() {
        JLabel stubLabel = new JLabel();
        return stubLabel; //stub
    }

    // EFFECTS: returns a subtitle for the popular bouquets panel
    private JLabel subTitle() {
        JLabel stubLabel = new JLabel();
        return stubLabel; //stub
    }

    // EFFECTS: returns a message that contains the given text and uses the given font size
    private JLabel status(String text, int fontSize) {
        JLabel stubLabel = new JLabel();
        return stubLabel; //stub
    }

    // EFFECTS: returns a button that contains the given text, changes color when mouse hovers over
    //          and performs the given action when pressed
    private JButton hover(String text, Color color, Color hover, ActionListener e) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to add flowers in popular bouquet one
    //          to their bouquet requirements list when pressed
    private JButton bouquetOneButton(Bouquet bouquet) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to add flowers in popular bouquet two
    //          to their bouquet requirements list when pressed
    private JButton bouquetTwoButton(Bouquet bouquet) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to add flowers in popular bouquet three
    //          to their bouquet requirements list when pressed
    private JButton bouquetThreeButton(Bouquet bouquet) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // EFFECTS: returns a button that allows users to return to the menu screen when pressed
    private JButton returnBtn(BouquetCustomizationAppGUI mainPanel) {
        JButton stubButton = new JButton();
        return stubButton; //stub
    }

    // MODIFIES: this
    // EFFECTS: sets up the popular bouquets panel and adds the title, subtitle, action buttons panel, and status
    public JPanel popularBouquets(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        JPanel stubPanel = new JPanel();
        return stubPanel; //stub
    }

    // MODIFIES: this
    // EFFECTS: sets up the action buttons panel and adds the status and buttons for popular bouquets one, two, three 
    //          and the return button
    private JPanel viewActions(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        JPanel stubPanel = new JPanel();
        return stubPanel; //stub
    }
}
