package Scoring;

import java.util.List;

public class Upper {

    private boolean bonus = false;
    private int upperTotal = 0;

    // Method to calculate and update the score for the current round
    public int calculateScore(List<Integer> diceValues, int target) {
        int scoreForThisRound = 0;

        for (int value : diceValues) {
            if (value == target) {
                scoreForThisRound += target;
            }
        }
        return scoreForThisRound;
    }

    // Getter for the total score
    public int getTotal() {
        return upperTotal;
    }

    // Getter for the bonus status
    public boolean hasBonus() {
        return bonus;
    }
}
