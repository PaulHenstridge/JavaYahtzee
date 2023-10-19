import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class YahtzeeGUI extends JFrame {

    public YahtzeeGUI() {
        setTitle("Yahtzee Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel with a border
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));  // Top-to-bottom layout

        // Create and add dice panels
        JPanel dicePanel = new JPanel(new GridLayout(1, 5));  // 1 row, 5 columns
        for (int i = 0; i < 5; i++) {
            JPanel singleDicePanel = createDicePanel();
            dicePanel.add(singleDicePanel);
        }
        mainPanel.add(dicePanel);

        // Create and add category panels
        String[] upperCategories = {"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes"};
        String[] lowerCategories = {"Three of a kind", "Four of a kind", "Full House", "Small Straight", "Large Straight", "Yahtzee", "Chance"};
        JPanel upperCategoryPanel = createCategoryPanel("Upper Section", upperCategories);
        JPanel lowerCategoryPanel = createCategoryPanel("Lower Section", lowerCategories);
        mainPanel.add(upperCategoryPanel);
        mainPanel.add(lowerCategoryPanel);

        // Add main panel to frame's content pane
        add(mainPanel);

        pack();  // Adjusts the frame size to fit the preferred size of its components
        setLocationRelativeTo(null);  // Centers the frame on the screen
        setVisible(true);
    }

    private JPanel createDicePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel diceLabel = new JLabel("1", SwingConstants.CENTER);  // Initial dice value is 1
        JButton holdButton = new JButton("Hold");
        panel.add(diceLabel, BorderLayout.CENTER);
        panel.add(holdButton, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createCategoryPanel(String title, String[] categories) {
        JPanel panel = new JPanel(new GridLayout(categories.length, 2));  // Each category with its score
        panel.setBorder(BorderFactory.createTitledBorder(title));
        for (String category : categories) {
            JLabel categoryLabel = new JLabel(category);
            JLabel scoreLabel = new JLabel("_");
            panel.add(categoryLabel);
            panel.add(scoreLabel);
        }
        return panel;
    }

    public static void main(String[] args) {
        new YahtzeeGUI();
    }
}
