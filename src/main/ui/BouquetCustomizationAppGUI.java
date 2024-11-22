package ui;

import java.util.ArrayList;

import model.Bouquet;

import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Bouquet customization application's main window frame
public class BouquetCustomizationAppGUI extends JFrame {
    private Bouquet bouquet;
    private static final String BOUTIQUE = "./data/boutique.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JLabel statusLabel;

    // EFFECTS: sets up bouquet, json reader and writer, and main panel screen
    // code source from LabelChanger, SmartHome and AlarmController
    public BouquetCustomizationAppGUI() throws FileNotFoundException {
        super("Bouquet Customization App");
        bouquet = new Bouquet("Customer1", new ArrayList<>(), 0);
        jsonWriter = new JsonWriter(BOUTIQUE);
        jsonReader = new JsonReader(BOUTIQUE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(600, 400));
        setLocationRelativeTo(null);
        setResizable(false);

        statusLabel = new JLabel();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(homeScreen(), "home");
        mainPanel.add(runCustomization(), "menu");

        add(mainPanel);
        setVisible(true);
    }

    protected JPanel getMainPanel() {
        return mainPanel;
    }

    protected CardLayout getCardLayout() {
        return cardLayout;
    }

    // EFFECTS: returns a message that contains the given text and uses the given font size
    private JLabel status(String text, int fontSize) {
        JLabel statusLabel = new JLabel(text, JLabel.CENTER);
        statusLabel.setFont(new Font("Sans-serif", Font.PLAIN, fontSize));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return statusLabel;
    }

    // EFFECTS: returns a thank you message  
    private JLabel thank() {
        JLabel thank = new JLabel("Thank you for using the Bouquet Customization Application", JLabel.CENTER);
        thank.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        thank.setAlignmentX(Component.CENTER_ALIGNMENT);
        return thank;
    }

    // REQUIRES: action != null
    // EFFECTS: returns a button that contains the given text, changes color when mouse hovers over
    //          and performs the given action when pressed
    private JButton hover(String text, Color color, Color hover, ActionListener e) {
        JButton button = new JButton(text);
        button.setBackground(color);
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

    // EFFECTS: returns a button that allows users to load a previously saved bouquet when pressed
    private JButton loadBtn() {
        return hover(
                "Load previously saved bouquet",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> loadBouquet());
    }

    // EFFECTS: returns a button that allows users to create a new bouquet when pressed
    private JButton newBtn() {
        return hover(
                "Create new bouquet",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> cardLayout.show(mainPanel, "menu"));
    }

    // EFFECTS: returns a button that allows users to proceed to the menu screen when pressed
    private JButton continueBtn() {
        return hover(
                "Continue to menu",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> cardLayout.show(mainPanel, "menu"));
    }

    // EFFECTS: returns a button that allows users to return to the menu screen when pressed
    private JButton returnBtn() {
        return hover(
                "Return to menu",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> cardLayout.show(mainPanel, "menu"));
    }

    // REQUIRES: flower != null
    // EFFECTS: returns a button that directs users to the add flower panel when pressed
    private JButton addFlowerBtn(FlowerUI flower) {
        return hover(
                "Add a flower",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> {
                    JPanel addPanel = flower.addFlower(this, bouquet);
                    mainPanel.add(addPanel, "addFlower");
                    cardLayout.show(mainPanel, "addFlower");
                });
    }

    // REQUIRES: flower != null
    // EFFECTS: returns a button that directs users to the remove flower panel when pressed
    private JButton removeFlowerBtn(FlowerUI flower) {
        return hover(
                "Remove a flower",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> {
                    JPanel removePanel = flower.removeFlower(this, bouquet);
                    mainPanel.add(removePanel, "removeFlower");
                    cardLayout.show(mainPanel, "removeFlower");
                });
    }

    // EFFECTS: returns a button that directs users to the view bouquet requirements list panel when pressed
    private JButton viewBouquetBtn() {
        return hover(
                "View bouquet requirements",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> {
                    BouquetUI viewBouquet = new BouquetUI();
                    JPanel viewPanel = viewBouquet.viewBouquet(this, bouquet);
                    mainPanel.add(viewPanel, "view");
                    cardLayout.show(mainPanel, "view");
                });
    }
    
    // EFFECTS: returns a button that directs users to the popular bouquets panel when pressed
    private JButton popularBouquetsBtn() {
        return hover(
                "Select from popular bouquets",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> {
                    PopularBouquetUI popularBouquets = new PopularBouquetUI();
                    JPanel popPanel = popularBouquets.popularBouquets(this, bouquet);
                    mainPanel.add(popPanel, "view");
                    cardLayout.show(mainPanel, "view");
                });
    }

    // EFFECTS: returns a button that brings users to the saving bouquet screen when pressed
    private JButton quitAppBtn() {
        return hover(
                "Quit application",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> quitScreen());
    }

    // EFFECTS: returns a button that saves the users bouquet requirements list to file 
    //          and then closes the application when pressed
    private JButton saveBtn() {
        return hover(
                "Save bouquet and quit",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> {
                    saveBouquet();
                    Timer timer = new Timer(1500, t -> {
                        dispose();
                    });
                    timer.setRepeats(false);
                    timer.start();
                });
    }

    // EFFECTS: returns a button that closes the application when pressed
    private JButton quitBtn() {
        return hover(
                "Quit without saving",
                new Color(208, 240, 192),
                new Color(233, 255, 219),
                e -> dispose());
    }

    // MODIFIES: this
    // EFFECTS: sets up the home panel and adds a greeting message, load and new bouquet buttons and a gif to the panel
    private JPanel homeScreen() {
        JPanel homeScreen = new JPanel(new BorderLayout());
        homeScreen.setBackground(new Color(250, 240, 230));

        JLabel greeting = new JLabel("Welcome to Bouquet Customization Application", JLabel.CENTER);
        greeting.setFont(new Font("Sans-serif", Font.PLAIN, 25));
        homeScreen.add(greeting, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(250, 240, 230));

        JButton loadBtn = loadBtn();
        JButton newBtn = newBtn();

        buttonPanel.add(loadBtn);
        buttonPanel.add(newBtn);

        homeScreen.add(buttonPanel, BorderLayout.CENTER);
        homeScreen.add(gifPanel(), BorderLayout.SOUTH);

        return homeScreen;
    }

    // MODIFIES: this
    // EFFECTS: sets up the gif in a container to be added to the home screen
    private JPanel gifPanel() {
        JPanel gif = new JPanel();
        gif.setLayout(new BorderLayout());
        gif.setBackground(new Color(250, 240, 230));
        ImageIcon gifImage = new ImageIcon(getClass().getResource("/assests/Starting_gif.gif"));
        Image scaledImage = gifImage.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledGifImage = new ImageIcon(scaledImage);
        JLabel firstImage = new JLabel(scaledGifImage);
        firstImage.setHorizontalAlignment(SwingConstants.CENTER);
        gif.add(firstImage, BorderLayout.CENTER);

        return gif;
    }

    // MODIFIES: this
    // EFFECTS: sets up a menu panel and adds a call to action message and the actions button panel
    private JPanel runCustomization() {
        JPanel menuScreen = new JPanel(new BorderLayout());
        menuScreen.setBackground(new Color(250, 240, 230));

        JLabel action = new JLabel("Select action below", JLabel.CENTER);
        action.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        menuScreen.add(action, BorderLayout.NORTH);

        menuScreen.add(buttonPanel(), BorderLayout.CENTER);
        return menuScreen;
    }

    // MODIFIES: this
    // EFFECTS: sets up a actions button panel and adds five buttons:
    //          addFlowerBtn, removeFlowerBtn, viewBouquetBtn, popularBouquetsBtn, quitAppBtn
    private JPanel buttonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        buttonPanel.setBackground(new Color(250, 240, 230));
        FlowerUI flower = new FlowerUI();

        buttonPanel.add(addFlowerBtn(flower));
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(removeFlowerBtn(flower));
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(viewBouquetBtn());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(popularBouquetsBtn());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(quitAppBtn());

        return buttonPanel;
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file and displays a status message about the loading state
    private void loadBouquet() {
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusLabel = status("", 16);
        statusPanel.add(statusLabel, BorderLayout.CENTER);
        statusPanel.setBackground(new Color(250, 240, 230));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(250, 240, 230));
        JButton continueBtn = continueBtn();
        buttonPanel.add(continueBtn);
        statusPanel.add(buttonPanel, BorderLayout.SOUTH);

        try {
            bouquet = jsonReader.read();
            String loadedMsg = "Loaded " + bouquet.getName() + " from " + BOUTIQUE;
            statusLabel.setText(loadedMsg);
        } catch (IOException e) {
            String notLoadedMsg = "Unable to read from file: " + BOUTIQUE;
            statusLabel.setText(notLoadedMsg);
        }

        mainPanel.add(statusPanel, "status");
        cardLayout.show(mainPanel, "status");
    }

    // EFFECTS: saves the workroom to file and displays a status message about the loading state
    private void saveBouquet() {
        try {
            jsonWriter.open();
            jsonWriter.write(bouquet);
            jsonWriter.close();
            String savedMsg = "Saved " + bouquet.getName() + " to " + BOUTIQUE;
            statusLabel.setText(savedMsg);
        } catch (FileNotFoundException e) {
            String notSavedMsg = "Unable to write to file: " + BOUTIQUE;
            statusLabel.setText(notSavedMsg);
        }
    }

    // MODIFIES: this
    // EFFECTS: sets up a quit application panel and adds save and quit buttons 
    //          and a sample bouquet photo with description
    private void quitScreen() {
        JPanel quitPanel = new JPanel();
        quitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        quitPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        quitPanel.setBackground(new Color(250, 240, 230));

        JButton saveBtn = saveBtn();
        JButton quitBtn = quitBtn();

        quitPanel.add(thank());
        quitPanel.add(saveBtn);
        quitPanel.add(quitBtn);
        statusLabel = status("", 14);

        quitPanel.add(Box.createHorizontalStrut(20));
        quitPanel.add(returnBtn());

        JPanel centerEnd = new JPanel();
        centerEnd.setLayout(new BoxLayout(centerEnd, BoxLayout.Y_AXIS));
        centerEnd.setBackground(new Color(250, 240, 230));
        centerEnd.add(endPhoto());
        centerEnd.add(Box.createVerticalStrut(10));
        centerEnd.add(statusLabel);
        quitPanel.add(centerEnd);

        mainPanel.add(quitPanel, "quit");
        cardLayout.show(mainPanel, "quit");
    }

    // MODIFIES: this
    // EFFECTS: sets up the photo with description in a container to be added to the quit application screen
    private JPanel endPhoto() {
        JPanel photo = new JPanel();
        photo.setLayout(new BoxLayout(photo, BoxLayout.Y_AXIS));
        photo.setAlignmentX(Component.CENTER_ALIGNMENT);
        photo.setBackground(new Color(250, 240, 230));
        ImageIcon lastPhoto = new ImageIcon(getClass().getResource("/assests/Ending_flowers.jpg"));
        Image scaledPhoto = lastPhoto.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledLastPhoto = new ImageIcon(scaledPhoto);
        JLabel endPhoto = new JLabel(scaledLastPhoto);
        endPhoto.setAlignmentX(Component.CENTER_ALIGNMENT);
        photo.add(endPhoto);

        JLabel sample = new JLabel("Here we have a sample bouquet", JLabel.CENTER);
        sample.setFont(new Font("Sans-serif", Font.PLAIN, 13));
        sample.setAlignmentX(Component.CENTER_ALIGNMENT);
        photo.add(sample);
        return photo;
    }
}