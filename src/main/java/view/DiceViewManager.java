package view;

import javax.swing.*;
import java.util.List;

public class DiceViewManager {
    private DiceViewListener listener;
    private List<Integer> diceValues;

    public DiceViewManager(List<Integer> diceValues) {
        this.diceValues = diceValues;
    }

    public void updateDiceValues(List<Integer> newDiceValues) {
        if (newDiceValues.size() != diceValues.size()) {
            throw new IllegalArgumentException("Size of newDiceValues must match the number of dice labels");
        }

        this.diceValues = newDiceValues;
    }

    public void rollButtonClicked(){
        if (listener != null) {
            listener.onRollButtonClicked();
        }
    }

    public void setDiceViewListener(DiceViewListener listener) {
        this.listener = listener;
    }
}
