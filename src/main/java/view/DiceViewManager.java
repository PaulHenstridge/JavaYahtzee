package view;

import javax.swing.*;
import java.util.List;

public class DiceViewManager implements IDiceViewManager {
    private DiceViewListener listener;
    YahtzeeViewModel viewModel;

    public DiceViewManager(YahtzeeViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void updateDiceValues(List<Integer> newDiceValues) {
//        if (newDiceValues.size() != diceValues.size()) {
//            throw new IllegalArgumentException("Size of newDiceValues must match the number of dice labels");
//        }
//        this.diceValues = newDiceValues;
    }

    @Override
    public void rollButtonClicked() {
        if (listener != null) {
            listener.onRollButtonClicked();
        }
    }

    @Override
    public void setDiceViewListener(DiceViewListener listener) {
        this.listener = listener;
    }


}


