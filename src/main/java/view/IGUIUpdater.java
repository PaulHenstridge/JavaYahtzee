package view;

import enums.YahtzeeEnums;

import java.util.List;

public interface IGUIUpdater {
    void updateDiceValues(List<Integer> newDiceValues);
    void updateUpperScore(int score, YahtzeeEnums.UpperCategory category);
}
