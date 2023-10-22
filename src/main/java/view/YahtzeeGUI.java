package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class YahtzeeGUI extends JFrame {
    List<JLabel> diceLabels = new ArrayList<>();


    public YahtzeeGUI() {
        setTitle("Yahtzee Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel with a border
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));  // Top-to-bottom layout

        // Create and add dice panels
        JPanel dicePanel = new JPanel(new GridLayout(1, 5, 30, 30));  // 1 row, 5 columns
        for (int i = 0; i < 5; i++) {
            JPanel singleDicePanel = createDicePanel();
            dicePanel.add(singleDicePanel);
        }
        mainPanel.add(dicePanel);
        // Create a panel to hold the roll button
        JPanel rollButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton rollButton = new JButton("Roll Dice");
        rollButton.setFont(new Font("Arial", Font.BOLD, 24));
        rollButtonPanel.add(rollButton);

// Add this panel to the main panel
        mainPanel.add(rollButtonPanel);

        // Create and add category panels
        String[] upperCategories = {"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes"};
        String[] lowerCategories = {"Three of a kind", "Four of a kind", "Full House", "Small Straight", "Large Straight", "Yahtzee", "Chance", "Yahtzee Bonus"};
        JPanel upperCategoryPanel = createCategoryPanel("Upper Section", upperCategories);
        JPanel lowerCategoryPanel = createCategoryPanel("Lower Section", lowerCategories);
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

private JPanel createDicePanel() {
    JPanel panel = new JPanel(new BorderLayout());

    // Create a wrapper panel with BoxLayout
    JPanel wrapper = new JPanel();
    wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.X_AXIS));

    JLabel diceLabel = new JLabel("1", SwingConstants.CENTER);
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

    panel.add(wrapper, BorderLayout.CENTER);  // Add wrapper instead of diceLabel
    panel.add(holdButton, BorderLayout.SOUTH);
    return panel;
}

    private JPanel createCategoryPanel(String title, String[] categories) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        JPanel categoryGrid = new JPanel(new GridLayout(categories.length, 3));

        for (String category : categories) {
            JLabel categoryLabel = new JLabel(category);
            JButton selectButton = new JButton("Select");
            JLabel scoreLabel = new JLabel("");
            scoreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            categoryGrid.add(categoryLabel);
            categoryGrid.add(selectButton);
            categoryGrid.add(scoreLabel);
        }
        panel.add(categoryGrid, BorderLayout.CENTER);

        JPanel scorePanel = new JPanel(new BorderLayout());
        JLabel scoreLabel = new JLabel("0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 32));

        scorePanel.add(new JLabel(title + " Score"), BorderLayout.NORTH);
        scorePanel.add(scoreLabel, BorderLayout.CENTER);

        JLabel bonusLabel = new JLabel("BONUS", SwingConstants.CENTER);
        bonusLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        Color labelColor = new Color(200, 200, 200);
        bonusLabel.setForeground(labelColor);
        bonusLabel.setBorder(BorderFactory.createLineBorder(labelColor, 1));

        scorePanel.add(bonusLabel, BorderLayout.SOUTH);

        panel.add(scorePanel, BorderLayout.EAST);

        return panel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        JPanel scorePanel = new JPanel(new BorderLayout());
        JLabel scoreLabel = new JLabel("0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 32));
        scorePanel.add(new JLabel("TOTAL SCORE"), BorderLayout.NORTH);
        scorePanel.add(scoreLabel, BorderLayout.CENTER);

        JPanel messagePanel = new JPanel(new BorderLayout());
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        messagePanel.add(new JLabel("Game Messages"), BorderLayout.NORTH);
        messagePanel.add(messageLabel, BorderLayout.CENTER);

        bottomPanel.add(scorePanel);
        bottomPanel.add(messagePanel);

        return bottomPanel;
    }

    public List<JLabel> getDiceLabels() {
        return diceLabels;
    }

    public static void main(String[] args) {
        new YahtzeeGUI();
    }
}
