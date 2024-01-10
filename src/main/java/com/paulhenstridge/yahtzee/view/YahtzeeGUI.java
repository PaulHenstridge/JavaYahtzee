package com.paulhenstridge.yahtzee.view;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.paulhenstridge.yahtzee.enums.YahtzeeEnums;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class YahtzeeGUI extends JFrame implements IGUIUpdater {
    private List<JLabel> diceLabels = new ArrayList<>();
    private List<JButton> holdButtons = new ArrayList<>();
    private List<JLabel> scoreLabels = new ArrayList<>();
    private List<JLabel> totalLabels = new ArrayList<>();
    private List<JLabel> bonusLabels = new ArrayList<>();
    private JButton resetButton;
    private JLabel grandTotalLabel;
    private boolean scoreButtonsClickable;

    private IViewEventHandler eventHandler;


    public YahtzeeGUI(IViewEventHandler eventHandler) {

        FlatDarculaLaf.setup();

        this.eventHandler = eventHandler;
//        this.scoreViewManager = scoreViewManager;

        setTitle("Yahtzee Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel with a border
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));  // Top-to-bottom layout

        // Create and add dice panels
        JPanel dicePanel = new JPanel(new GridLayout(1, 5, 30, 30));  // 1 row, 5 columns
        for (int i = 0; i < 5; i++) {
            JPanel singleDicePanel = createDicePanel(i);
            dicePanel.add(singleDicePanel);
        }
        mainPanel.add(dicePanel);

        // Create a panel to hold roll button
        JPanel rollButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton rollButton = new JButton("Roll Dice");
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventHandler.rollButtonClicked();
                scoreButtonsClickable = true;
            }
        });
        rollButton.setFont(new Font("Arial", Font.BOLD, 24));
        rollButtonPanel.add(rollButton);

        mainPanel.add(rollButtonPanel);

        // Create and add category panels
        String[] upperCategories = {"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes"};
        String[] lowerCategories = {"Three of a kind", "Four of a kind", "Full House", "Small Straight", "Large Straight", "Yahtzee", "Chance", "Yahtzee Bonus"};
        JPanel upperCategoryPanel = createCategoryPanel("Upper Section", YahtzeeEnums.Section.UPPER, YahtzeeEnums.UpperCategory.values());
        JPanel lowerCategoryPanel = createCategoryPanel("Lower Section",  YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.values());
        mainPanel.add(upperCategoryPanel);
        mainPanel.add(lowerCategoryPanel);

        // Create and add the bottom panel
        JPanel bottomPanel = createBottomPanel();
        mainPanel.add(bottomPanel);

        // Add main panel to frame's content pane
        add(mainPanel);

        pack();  // Adjusts the frame size to fit the preferred size of its components
        setLocationRelativeTo(null);  // Centers the frame on the screen
        setVisible(true);
    }

private JPanel createDicePanel(int index) {
    JPanel panel = new JPanel(new BorderLayout());

    // Create a wrapper panel with BoxLayout
    JPanel wrapper = new JPanel();
    wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.X_AXIS));

    // create dice labels
    JLabel diceLabel = new JLabel("?", SwingConstants.CENTER);
    diceLabel.setFont( new Font( "Arial", Font.BOLD, 24));
    diceLabel.setOpaque(true);
    diceLabel.setBackground(Color.BLACK);
    diceLabel.setForeground(Color.ORANGE);

    diceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    diceLabels.add(diceLabel);

    // Set a preferred size for diceLabel to make it square
    Dimension squareSize = new Dimension(50, 50);
    diceLabel.setPreferredSize(squareSize);
    diceLabel.setMaximumSize(squareSize);
    diceLabel.setMinimumSize(squareSize);

    wrapper.add(Box.createHorizontalGlue());
    wrapper.add(diceLabel);
    wrapper.add(Box.createHorizontalGlue());

    JButton holdButton = new JButton("Hold");
    holdButton.setActionCommand(String.valueOf(index));
    holdButton.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();
         int index = Integer.parseInt(command);
         eventHandler.holdButtonClicked(index);
     }
 });
    holdButtons.add(holdButton);

    panel.add(wrapper, BorderLayout.CENTER);
    panel.add(holdButton, BorderLayout.SOUTH);
    return panel;
}

    private JPanel createCategoryPanel(String title, YahtzeeEnums.Section section, Enum<?>[] categories) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        JPanel categoryGrid = new JPanel(new GridLayout(categories.length, 3));

        for (Enum<?> category : categories) {
//            JLabel categoryLabel = new JLabel(formatEnumName(category.toString()));

            JButton selectButton = new JButton(formatEnumName(category.toString()));
            String compositeCommand = section.name() + ":" + category.name();
            selectButton.setActionCommand(compositeCommand);
            selectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (scoreButtonsClickable){
                        String command = e.getActionCommand();
                        String[] parts = command.split(":");
                        Enum<?> scoreCategory = null;
                        if (parts.length == 2){
                            if ( "UPPER".equals(parts[0])){
                                scoreCategory = YahtzeeEnums.UpperCategory.valueOf(parts[1]);
                            }
                            if ("LOWER".equals(parts[0])){
                                scoreCategory = YahtzeeEnums.LowerCategory.valueOf(parts[1]);
                            }
                        }
                        if (scoreCategory != null) {
                            eventHandler.scoreButtonClicked(scoreCategory);
                            selectButton.setForeground(Color.DARK_GRAY);
                            selectButton.setEnabled(false);
                            scoreButtonsClickable = false;
                        } else {
                            // TODO - handle errors here
                        }
                    }
                }
            });

            JLabel scoreLabel = new JLabel("");
            scoreLabel.setFont(new Font("Arial", Font.PLAIN, 21));
            scoreLabel.putClientProperty("category", category);
            scoreLabels.add(scoreLabel);
            scoreLabel.setHorizontalAlignment(JLabel.CENTER);
            scoreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
//            categoryGrid.add(categoryLabel);
            categoryGrid.add(selectButton);
            categoryGrid.add(scoreLabel);
        }
        panel.add(categoryGrid, BorderLayout.CENTER);

        JPanel scorePanel = new JPanel(new BorderLayout());
        JLabel totalLabel = new JLabel("0", SwingConstants.CENTER);
        totalLabel.putClientProperty("section", title );
        totalLabel.setFont(new Font("Arial", Font.BOLD, 32));
        totalLabels.add(totalLabel);

        scorePanel.add(new JLabel(title + " Score"), BorderLayout.NORTH);
        scorePanel.add(totalLabel, BorderLayout.CENTER);
        // todo add scorePanel to List scoreTotals

        JLabel bonusLabel = new JLabel("BONUS", SwingConstants.CENTER);
        bonusLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        Color labelColor = new Color(200, 200, 200);
        bonusLabel.setForeground(labelColor);
        bonusLabel.setBorder(BorderFactory.createLineBorder(labelColor, 1));

        bonusLabel.putClientProperty("section", section);
        bonusLabels.add(bonusLabel);

        scorePanel.add(bonusLabel, BorderLayout.SOUTH);

        panel.add(scorePanel, BorderLayout.EAST);

        return panel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        JPanel scorePanel = new JPanel(new BorderLayout());
        grandTotalLabel = new JLabel("0", SwingConstants.CENTER);
        grandTotalLabel.setFont(new Font("Arial", Font.BOLD, 32));
        scorePanel.add(new JLabel("TOTAL SCORE"), BorderLayout.NORTH);
        scorePanel.add(grandTotalLabel, BorderLayout.CENTER);

        JPanel messagePanel = new JPanel(new BorderLayout());
        resetButton = new JButton("Reset Game");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 18));
//        messagePanel.add(new JLabel("Game Messages"), BorderLayout.NORTH);
        messagePanel.add(resetButton, BorderLayout.CENTER);

        bottomPanel.add(scorePanel);
        bottomPanel.add(messagePanel);

        return bottomPanel;
    }

    public List<JLabel> getDiceLabels() {
        return diceLabels;
    }

@Override
public void updateDiceValues(List<Integer> newDiceValues) {
    for (int i = 0; i < newDiceValues.size(); i++) {
        diceLabels.get(i).setText(String.valueOf(newDiceValues.get(i)));
    }
}

public void updateUpperScore(int score, YahtzeeEnums.UpperCategory category){
    for (JLabel label : scoreLabels){
        if ( category.equals(label.getClientProperty("category"))){
            label.setText(String.valueOf(score));
            label.setOpaque(true);
            label.setBackground(Color.ORANGE);
            label.setForeground(Color.BLACK);
        }
    }
}

public void updateLowerScore(int score, YahtzeeEnums.LowerCategory category){
    for (JLabel label : scoreLabels){
        if ( category.equals(label.getClientProperty("category"))){
            label.setText(String.valueOf(score));
            label.setOpaque(true);
            label.setBackground(Color.ORANGE);
            label.setForeground(Color.BLACK);
        }
    }
}
    public void updateUpperTotal(int newTotal){
        for ( JLabel label : totalLabels) {
            if ("Upper Section".equals(label.getClientProperty("section"))) {
                label.setText(String.valueOf(newTotal));
            }
        }
    }

    public void updateLowerTotal(int newTotal){
        for ( JLabel label : totalLabels) {
            if ("Lower Section".equals(label.getClientProperty("section")) ){
                label.setText(String.valueOf(newTotal));
            }
        }
    }

    public void updateGrandTotal(int newGrandTotal){
        grandTotalLabel.setText(String.valueOf(newGrandTotal));
    }

    public void updateBonus(YahtzeeEnums.Section section, boolean newState){
        for(JLabel bonusLabel : bonusLabels){
            YahtzeeEnums.Section bonusSection = (YahtzeeEnums.Section) bonusLabel.getClientProperty("section");
            if ( bonusSection == section){
                bonusLabel.setForeground(Color.GREEN);
                bonusLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));

                // TODO - change text color etc of bonus
            }
        }
    }

    public void updateHoldButtons(List<Boolean> holdList){
        if (holdList.size() == 5){
            for(int i = 0; i<=4; i++){
                if(holdList.get(i)){
                    holdButtons.get(i).setBackground(Color.BLUE);
                } else {
                    holdButtons.get(i).setBackground(new Color(78, 80, 82));
                }
            }
        } else {
            // error handling
        }
    }

    public static String formatEnumName(String enumName) {
        String[] words = enumName.toLowerCase().split("_");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)));
            sb.append(word.substring(1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
