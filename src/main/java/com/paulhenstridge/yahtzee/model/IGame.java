package com.paulhenstridge.yahtzee.model;

import com.paulhenstridge.yahtzee.enums.YahtzeeEnums;
import com.paulhenstridge.yahtzee.model.scoring.ScoreKeeper;

import java.util.List;

public interface IGame {
    boolean scoreUpper(YahtzeeEnums.UpperCategory category);
    boolean scoreThreeOfAKind();
    boolean scoreFourOfAKind();
    boolean scoreYahtzee();
    boolean scoreFullHouse();
    boolean scoreSmallStraight();
    boolean scoreLargeStraight();
    boolean scoreChance();
    void rollDice();
    List<Integer> getCurrentDice();
    Integer getCategoryScore(YahtzeeEnums.Section section, Enum<?> category);
    void toggleHoldButton(int index);
    void clearHolds();
    int getUpperTotal();
    int getLowerTotal();
    int getGrandTotal();
    boolean getUpperBonus();
    List<Boolean> getHoldList();
    int getTurnsRemaining();
    void setTurnsRemaining(int turnsRemaining);
    boolean getLowerBonus();
    void setLowerBonus(boolean status);
    void scoreLowerBonus();

    ScoreKeeper getScoreKeeper();
}
