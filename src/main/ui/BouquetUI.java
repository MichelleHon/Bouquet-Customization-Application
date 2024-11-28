package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Bouquet;
import model.Flower;

// Bouquet customization application's viewing bouquet requirements list frame
public class BouquetUI extends JFrame {
    private JLabel statusLabel;

    // EFFECTS: returns a button that contains the given text, changes color when
    // mouse hovers over
    // and performs the given action when pressed
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

    // EFFECTS: returns a button that allows users to return to the menu screen when
    // pressed
    private JButton returnBtn(BouquetCustomizationAppGUI mainPanel) {
        return hover(
                "Return to menu",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> mainPanel.getCardLayout().show(mainPanel.getMainPanel(), "menu"));
    }

    // EFFECTS: returns a button that allows users to remove all flowers from their
    // bouquet list when pressed
    private JButton clearAllBtn(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        return hover(
                "Clear all flowers",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> {
                    int confirm = JOptionPane.showConfirmDialog(mainPanel,
                            "Are you sure you would like to remove all flowers from your list?",
                            "Clear all",
                            JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        bouquet.removeAllFlowers(bouquet.getBouquetRequirements());
                        statusLabel.setText("All flowers have been removed");
                    }
                });
    }

    // EFFECTS: returns a message that tells users the list they are viewing
    private JLabel viewFlowerPrompt() {
        JLabel viewFlowerPrompt = new JLabel("Current bouquet contents");
        viewFlowerPrompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        return viewFlowerPrompt;
    }

    // EFFECTS: returns a message that contains the given text and uses the given
    // font size
    private JLabel status(String text, int fontSize) {
        JLabel statusLabel = new JLabel(text, JLabel.CENTER);
        statusLabel.setFont(new Font("Sans-serif", Font.PLAIN, fontSize));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return statusLabel;
    }

    // EFFECTS: sets up a text area that displays the list of flowers in users
    // bouquet requirements list
    private JTextArea bouquetContents() {
        JTextArea bouquetContents = new JTextArea(10, 20);
        bouquetContents.setEditable(false);
        bouquetContents.setLineWrap(true);
        bouquetContents.setWrapStyleWord(true);
        return bouquetContents;
    }

    // EFFECTS: sets up a scroll panel that in the text area
    private JScrollPane scrollPane(JTextArea textArea) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(new EmptyBorder(30, 210, 30, 210));
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.setBackground(new Color(250, 240, 230));
        return scrollPane;
    }

    // MODIFIES: this
    // EFFECTS: sets up view flowers in users bouquet requirements list panel
    // and adds a status label, text area, scroll panel and a clear all flowers from
    // list button
    public JPanel viewBouquet(BouquetCustomizationAppGUI mainPanel, Bouquet bouquet) {
        JPanel viewFlowersPanel = new JPanel();
        viewFlowersPanel.setLayout(new BoxLayout(viewFlowersPanel, BoxLayout.Y_AXIS));
        viewFlowersPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        viewFlowersPanel.setBackground(new Color(250, 240, 230));

        statusLabel = status("", 13);

        viewFlowersPanel.add(viewFlowerPrompt());

        JTextArea bouquetContents = bouquetContents();
        JScrollPane scrollPane = scrollPane(bouquetContents);

        viewFlowersPanel.add(scrollPane);

        String contents = "";
        for (Flower f : bouquet.getBouquetRequirements()) {
            contents += f.getFlowerName() + "\n";
        }
        if (contents.isEmpty()) {
            contents = "The bouquet is currently empty";
        }

        bouquetContents.setText(contents);

        viewFlowersPanel.add(clearAllBtn(mainPanel, bouquet));
        viewFlowersPanel.add(statusLabel);
        viewFlowersPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        viewFlowersPanel.add(returnBtn(mainPanel));

        return viewFlowersPanel;
    }
}
