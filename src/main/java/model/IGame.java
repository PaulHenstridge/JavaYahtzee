package model;

import model.scoring.ScoreKeeper;

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
    void holdDie(int index);
    void unholdDie(int index);
    void clearHolds();
    int getUpperScore();
    int getLowerScore();
    ScoreKeeper getScoreKeeper();
}