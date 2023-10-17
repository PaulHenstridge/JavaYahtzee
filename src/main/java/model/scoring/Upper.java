package model.scoring;

import java.util.List;

public class Upper {

    private boolean bonus = false;
    private int upperTotal = 0;

    // Method to calculate and update the score for the current round
    public int calculateScore(List<Integer> diceValues, int target) {

        for (int value : diceValues) {
            if (value == target) {
                upperTotal += target;
            }
        }
        return upperTotal;
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
