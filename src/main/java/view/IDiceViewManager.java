package view;

import java.util.List;

public interface IDiceViewManager {
    void updateDiceValues(List<Integer> newDiceValues);
    void rollButtonClicked();
    void setDiceViewListener(DiceViewListener listener);

}
