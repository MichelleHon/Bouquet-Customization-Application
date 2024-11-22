package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.Bouquet;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Bouquet customization application's popular bouquets window frame
public class PopularBouquetUI extends JPanel {
    private JLabel statusLabel;

    // EFFECTS: returns a title for the popular bouquets panel
    private JLabel title() {
        JLabel title = new JLabel("Here are our top 3 bouquets");
        title.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        return title;
    }

    // EFFECTS: returns a subtitle for the popular bouquets panel
    private JLabel subTitle() {
        JLabel subTitle = new JLabel("You may choose them as a base and customize further");
        subTitle.setFont(new Font("Sans-serif", Font.PLAIN, 13));
        subTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        return subTitle;
    }

    // EFFECTS: returns a message that contains the given text and uses the given font size
    private JLabel status(String text, int fontSize) {
        JLabel statusLabel = new JLabel(text, JLabel.CENTER);
        statusLabel.setFont(new Font("Sans-serif", Font.PLAIN, fontSize));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return statusLabel;
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

    // EFFECTS: returns a button that allows users to add flowers in popular bouquet one
    //          to their bouquet requirements list when pressed
    private JButton bouquetOneButton(Bouquet bouquet) {
        return hover(
                "1: Classic Garden Rose($80)",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> {
                    bouquet.addPopBouquetOne();
                    statusLabel.setText("Added popular bouquet 1");
                });
    }

    // EFFECTS: returns a button that allows users to add flowers in popular bouquet two
    //          to their bouquet requirements list when pressed
    private JButton bouquetTwoButton(Bouquet bouquet) {
        return hover(
                "2: Sunshine Delight($105)",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> {
                    bouquet.addPopBouquetTwo();
                    statusLabel.setText("Added popular bouquet 2");
                });
    }

    // EFFECTS: returns a button that allows users to add flowers in popular bouquet three
    //          to their bouquet requirements list when pressed
    private JButton bouquetThreeButton(Bouquet bouquet) {
        return hover(
                "3: Spring Elegance($130)",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> {
                    bouquet.addPopBouquetThree();
                    statusLabel.setText("Added popular bouquet 3");
                });
    }

    // EFFECTS: returns a button that allows users to return to the menu screen when pressed
    private JButton returnBtn(BouquetCustomizationAppGUI mainPanel) {
        return hover(
                "Return to menu",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> mainPanel.getCardLayout().show(mainPanel.getMainPanel(), "menu"));
    }

    // MODIFIES: this
    // EFFECTS: sets up the popular bouquets panel and adds the title, subtitle, action buttons panel, and status
    public JPanel popularBouquets(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        JPanel popBouquetPanel = new JPanel();
        popBouquetPanel.setLayout(new BoxLayout(popBouquetPanel, BoxLayout.Y_AXIS));
        popBouquetPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        popBouquetPanel.setBackground(new Color(250, 240, 230));

        JLabel title = title();
        JLabel subTitle = subTitle();
        popBouquetPanel.add(title);
        popBouquetPanel.add(subTitle);
        popBouquetPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel actionsPanel = viewActions(mainPanel, bouquet);
        actionsPanel.setBackground(new Color(250, 240, 230));
        popBouquetPanel.add(actionsPanel);
        popBouquetPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        statusLabel = status("", 13);
        popBouquetPanel.add(statusLabel);

        return popBouquetPanel;
    }

    // MODIFIES: this
    // EFFECTS: sets up the action buttons panel and adds the status and buttons for popular bouquets one, two, three 
    //          and the return button
    private JPanel viewActions(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        statusLabel = status("", 13);

        panel.add(bouquetOneButton(bouquet));
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(bouquetTwoButton(bouquet));
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(bouquetThreeButton(bouquet));
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        panel.add(returnBtn(mainPanel));
        return panel;
    }
}
