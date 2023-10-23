package model;

import model.dice.Dice;
import model.dice.YahtzeeDiceController;
import model.scoring.Lower;
import model.scoring.ScoreKeeper;
import model.scoring.UpdateStatus;
import model.scoring.Upper;

import java.util.List;

public class Game implements IGame{
    private YahtzeeDiceController dice;
    private Lower lower;
    private Upper upper;
    private ScoreKeeper scoreKeeper;


    public Game(YahtzeeDiceController dice, ScoreKeeper scoreKeeper, Upper upper, Lower lower) {
        this.dice = dice;
        this.lower = lower;
        this.upper = upper;
        this.scoreKeeper = scoreKeeper;
    }

    public boolean scoreUpper(YahtzeeEnums.UpperCategory category) {
        int diceVal = category.getDiceVal();
        int score = upper.calculateScore(dice.getDiceValues(), diceVal);
        UpdateStatus status = scoreKeeper.updateScore(score, YahtzeeEnums.Section.UPPER, category);
        return status.isSuccess();
    }

    public boolean scoreThreeOfAKind() {
        int score = lower.checkNumberOfAKind(dice.getDiceValues(), 3);
        UpdateStatus status = scoreKeeper.updateScore(score, YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.THREE_OF_A_KIND);
        return status.isSuccess();
    }

    public boolean scoreFourOfAKind(){
        int score = lower.checkNumberOfAKind(dice.getDiceValues(), 4);
        UpdateStatus status = scoreKeeper.updateScore(score, YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.FOUR_OF_A_KIND);
        return status.isSuccess();
    }
   public boolean scoreYahtzee(){
        int score = lower.checkYahtzee(dice.getDiceValues());
        UpdateStatus status = scoreKeeper.updateScore(score, YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.YAHTZEE);
        return status.isSuccess();
    }
       public boolean scoreFullHouse(){
        int score = lower.checkFullHouse(dice.getDiceValues());
        UpdateStatus status = scoreKeeper.updateScore(score, YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.FULL_HOUSE);
        return status.isSuccess();
    }
          public boolean scoreSmallStraight(){
        int score = lower.checkSmallStraight(dice.getDiceValues());
        UpdateStatus status = scoreKeeper.updateScore(score, YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.SMALL_STRAIGHT);
        return status.isSuccess();
    }
          public boolean scoreLargeStraight(){
        int score = lower.checkLargeStraight(dice.getDiceValues());
        UpdateStatus status = scoreKeeper.updateScore(score, YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.LARGE_STRAIGHT);
        return status.isSuccess();
    }
          public boolean scoreChance(){
        int score = lower.checkChance(dice.getDiceValues());
        UpdateStatus status = scoreKeeper.updateScore(score, YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.CHANCE);
        return status.isSuccess();
    }

    public void rollDice(){
        dice.rollDice();
    }

    public List<Integer> getCurrentDice(){
        return dice.getDiceValues();
    }

    public Integer getCategoryScore(YahtzeeEnums.Section section, Enum<?> category){
        return scoreKeeper.getScore(section, category);
    }

    public void holdDie(int index){
        dice.holdDice(index);
    }
    public void unholdDie(int index){
        dice.releaseDice(index);
    }

    public void clearHolds(){
        dice.resetHolds();
    }

    public int getUpperScore() {
        return scoreKeeper.getUpperScore();
    }
    public int getLowerScore() {
        return scoreKeeper.getLowerScore();
    }

    public ScoreKeeper getScoreKeeper() {
        return scoreKeeper;
    }

}