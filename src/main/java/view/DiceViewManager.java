package view;

import javax.swing.*;
import java.util.List;

public class DiceViewManager {
    private final List<JLabel> diceLabels;

    public DiceViewManager(List<JLabel> diceLabels) {
        this.diceLabels = diceLabels;
    }

    public void updateDiceValues(List<Integer> newDiceValues) {
        if (newDiceValues.size() != diceLabels.size()) {
            throw new IllegalArgumentException("Size of newDiceValues must match the number of dice labels");
        }

        for (int i = 0; i < newDiceValues.size(); i++) {
            diceLabels.get(i).setText(newDiceValues.get(i).toString());
        }
    }
}
