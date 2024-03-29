package com.paulhenstridge.yahtzee.model;

import com.paulhenstridge.yahtzee.enums.YahtzeeEnums;
import com.paulhenstridge.yahtzee.model.dice.DiceController;
import com.paulhenstridge.yahtzee.model.scoring.Lower;
import com.paulhenstridge.yahtzee.model.scoring.ScoreKeeper;
import com.paulhenstridge.yahtzee.model.scoring.UpdateStatus;
import com.paulhenstridge.yahtzee.model.scoring.Upper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Game implements IGame{
    private DiceController dice;
    private Lower lower;
    private Upper upper;
    private ScoreKeeper scoreKeeper;
    private int turnsRemaining = 3;


    public Game(DiceController dice, ScoreKeeper scoreKeeper, Upper upper, Lower lower) {
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

    public void scoreLowerBonus(){
        this.setLowerBonus(true);
        int currentTotal = scoreKeeper.getLowerTotal();
        scoreKeeper.setLowerTotal(currentTotal + 100);
    }

    public void rollDice(){
        dice.rollDice();
        turnsRemaining--;
    }

    public int getTurnsRemaining() {
        return turnsRemaining;
    }

    public void setTurnsRemaining(int turnsRemaining) {
        this.turnsRemaining = turnsRemaining;
    }

    public List<Integer> getCurrentDice(){
        return dice.getDiceValues();
    }

    public Integer getCategoryScore(YahtzeeEnums.Section section, Enum<?> category){
        return scoreKeeper.getScore(section, category);
    }

    public void toggleHoldButton(int index){
        dice.toggleHold(index);
    }


    public List<Boolean> getHoldList(){
        return dice.getHoldList();
    }

    public void clearHolds(){
        dice.resetHolds();
    }

    public int getUpperTotal() {
        return scoreKeeper.getUpperTotal();
    }
    public int getLowerTotal() {
        return scoreKeeper.getLowerTotal();
    }


    public int getGrandTotal() {
        return scoreKeeper.getGrandTotal();
    }
    public boolean getUpperBonus(){
        return scoreKeeper.isUpperBonus();
    }
    public boolean getLowerBonus(){
        return scoreKeeper.isLowerBonus();
    }

    public void setLowerBonus(boolean status){
        scoreKeeper.setLowerBonus(status);
    }

    public ScoreKeeper getScoreKeeper() {
        return scoreKeeper;
    }

}