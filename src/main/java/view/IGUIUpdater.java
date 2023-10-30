package view;

import enums.YahtzeeEnums;

import java.util.List;

public interface IGUIUpdater {
    void updateDiceValues(List<Integer> newDiceValues);
    void updateUpperScore(int score, YahtzeeEnums.UpperCategory category);
    void updateLowerScore(int score, YahtzeeEnums.LowerCategory category);
    void updateUpperTotal(int newUpperTotal);
    void updateLowerTotal(int newLowerTotal);
    void updateGrandTotal(int newGrandTotal);
    void updateBonus(YahtzeeEnums.Section section, boolean newState);
}
