package Scoring;

import java.util.List;

public class Upper {

    private boolean bonus = false;
    private int total = 0;

    // Method to calculate and update the score for the current round
    public int calculateScore(List<Integer> diceValues, int target) {
        int scoreForThisRound = 0;

        for (int value : diceValues) {
            if (value == target) {
                scoreForThisRound += target;
            }
        }

        // Update the total score
        total += scoreForThisRound;

        // Check if the bonus condition is met
        if (total >= 63 && !bonus) {
            bonus = true;
            total += 35;  // Assuming the bonus is 35 points
        }

        return scoreForThisRound;
    }

    // Getter for the total score
    public int getTotal() {
        return total;
    }

    // Getter for the bonus status
    public boolean hasBonus() {
        return bonus;
    }
}
