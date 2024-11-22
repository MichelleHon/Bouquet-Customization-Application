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
    private JLabel statusLabel;
    private JTextField textField;

    // EFFECTS: returns a message that contains the given text and uses the given font size
    private JLabel status(String text, int fontSize) {
        JLabel statusLabel = new JLabel(text, JLabel.CENTER);
        statusLabel.setFont(new Font("Sans-serif", Font.PLAIN, fontSize));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return statusLabel;
    }

    // EFFECTS: returns a message that prompts users to add a flower to their bouquet
    private JLabel addFlowerPrompt() {
        JLabel addFlowerPrompt = new JLabel("Enter a flower to add to the bouquet");
        addFlowerPrompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        return addFlowerPrompt;
    }

    // EFFECTS: returns a message that prompts users to remove a flower from their bouquet
    private JLabel removeFlowerPrompt() {
        JLabel removeFlowerPrompt = new JLabel("Enter a flower to remove from the bouquet");
        removeFlowerPrompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        return removeFlowerPrompt;
    }

    // EFFECTS: sets up a text field that allows users to type the flower name they would like to add or remove
    private JTextField textField() {
        JTextField flowerName = new JTextField(15);
        flowerName.setMaximumSize(new Dimension(150, 25));
        flowerName.setAlignmentX(Component.CENTER_ALIGNMENT);
        return flowerName;
    }
    
    // EFFECTS: returns a button that contains the given text, changes color when mouse hovers over
    //          and performs the given action when pressed
    private JButton hover(String text, Color color, Color hover, ActionListener e) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.addActionListener(e);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent en) {
                button.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent ex) {
                button.setBackground(color);
            }
        });
        return button;
    }

    // EFFECTS: returns a button that allows users to add a flower to their bouquet requirements list when pressed
    private JButton addFlowerButton(JTextField textField, Bouquet bouquet) {
        return hover(
                "Add",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> addFlowerToBouquet(textField, bouquet));
    }

    // EFFECTS: returns a button that allows users to return to the menu screen when pressed
    private JButton returnBtn(BouquetCustomizationAppGUI mainPanel) {
        return hover(
                "Return to menu",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> mainPanel.getCardLayout().show(mainPanel.getMainPanel(), "menu"));
    }

    // EFFECTS: returns a button that allows users to remove a flower from their bouquet requirements list when pressed
    private JButton removeFlowerButton(JTextField textField, Bouquet bouquet) {
        return hover(
                "Remove",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> removeFlowerFromBouquet(textField, bouquet));
    }

    // MODIFIES: this
    // EFFECTS: sets up the add flower panel 
    //          and adds a text field, status, message prompt, add flower and return buttons
    public JPanel addFlower(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        JPanel addFlowerPanel = new JPanel();
        addFlowerPanel.setLayout(new BoxLayout(addFlowerPanel, BoxLayout.Y_AXIS));
        addFlowerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        addFlowerPanel.setBackground(new Color(250, 240, 230));

        textField = textField();
        statusLabel = status("", 13);
        JLabel addFlowerPrompt = addFlowerPrompt();

        addFlowerPanel.add(addFlowerPrompt);
        addFlowerPanel.add(textField);
        addFlowerPanel.add(statusLabel);
        addFlowerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        addFlowerPanel.add(addFlowerButton(textField, bouquet));
        addFlowerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        addFlowerPanel.add(returnBtn(mainPanel));

        return addFlowerPanel;
    }

    // MODIFIES: this
    // EFFECTS: adds given flower name to bouquet requirements list 
    private void addFlowerToBouquet(JTextField flowerName, Bouquet bouquet) {
        Flower addFlower = new Flower(flowerName.getText());
        bouquet.flowerAdd(addFlower);
        statusLabel.setText(flowerName.getText() + " has been added");
        flowerName.setText("");
    }

    // MODIFIES: this
    // EFFECTS: sets up the remove flower panel 
    //          and adds a text field, status, message prompt, remove flower and return buttons
    public JPanel removeFlower(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        JPanel removeFlowerPanel = new JPanel();
        removeFlowerPanel.setLayout(new BoxLayout(removeFlowerPanel, BoxLayout.Y_AXIS));
        removeFlowerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        removeFlowerPanel.setBackground(new Color(250, 240, 230));

        textField = textField();
        statusLabel = status("", 13);
        JLabel removeFlowerPrompt = removeFlowerPrompt();

        removeFlowerPanel.add(removeFlowerPrompt);
        removeFlowerPanel.add(textField);
        removeFlowerPanel.add(statusLabel);
        removeFlowerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        removeFlowerPanel.add(removeFlowerButton(textField, bouquet));
        removeFlowerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        removeFlowerPanel.add(returnBtn(mainPanel));

        return removeFlowerPanel;
    }

    // MODIFIES: this
    // EFFECTS: takes the given flower name and checks if it is in the bouquet
    //          removes the flower if the given flower name is in the bouquet
    //          otherwise displays a error message
    private void removeFlowerFromBouquet(JTextField flowerName, Bouquet bouquet) {
        Iterator<Flower> iterator = bouquet.getBouquetRequirements().iterator();
        boolean flowerFound = false;

        while (iterator.hasNext()) {
            Flower currentFlower = iterator.next();
            if (currentFlower.getFlowerName().equalsIgnoreCase(flowerName.getText())) {
                bouquet.flowerRemove(currentFlower);
                flowerFound = true;
                break;
            }
        }
        if (!flowerFound) {
            statusLabel.setText(flowerName.getText() + " is not in bouquet");
            flowerName.setText("");
        } else {
            statusLabel.setText(flowerName.getText() + " has been removed");
            flowerName.setText("");
        }
    }
}
