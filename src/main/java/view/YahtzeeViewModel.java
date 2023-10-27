package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.List;

public class YahtzeeViewModel {
    private final PropertyChangeSupport support;
    private List<Integer> diceValues = Arrays.asList(1,1,1,1,1);

    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private boolean upperBonus;

    private int upperTotal;

    private int threeOfAKind;
    private int fourOfAKind;
    private int fullHouse;
    private int smallStraight;
    private int largeStraight;
    private int Yahtzee;
    private int chance;
    private int yahtzeeBonus;

    private int lowerTotal;
    private int grandTotal;


    public YahtzeeViewModel(){
        support = new PropertyChangeSupport(this);
    }

    public List<Integer> getDiceValues() {
        return diceValues;
    }

    public int getOnes() {
        return ones;
    }

    public int getTwos() {
        return twos;
    }

    public int getThrees() {
        return threes;
    }

    public int getFours() {
        return fours;
    }

    public int getFives() {
        return fives;
    }

    public int getSixes() {
        return sixes;
    }

    public boolean isUpperBonus() {
        return upperBonus;
    }

    public int getUpperTotal() {
        return upperTotal;
    }

    public int getThreeOfAKind() {
        return threeOfAKind;
    }

    public int getFourOfAKind() {
        return fourOfAKind;
    }

    public int getFullHouse() {
        return fullHouse;
    }

    public int getSmallStraight() {
        return smallStraight;
    }

    public int getLargeStraight() {
        return largeStraight;
    }

    public int getYahtzee() {
        return Yahtzee;
    }

    public int getChance() {
        return chance;
    }

    public int getYahtzeeBonus() {
        return yahtzeeBonus;
    }

    public int getLowerTotal() {
        return lowerTotal;
    }

    public int getGrandTotal() {
        return grandTotal;
    }


    public void setDiceValues(List<Integer> newDiceValues) {
        List<Integer> oldDiceValues = this.diceValues;
        this.diceValues = newDiceValues;
        support.firePropertyChange("diceValues", oldDiceValues, newDiceValues);
    }

    public void setOnes(int newVal) {
        int oldVal = this.ones;
        this.ones = newVal;
        support.firePropertyChange("ones", oldVal, newVal);
    }

    public void setTwos(int twos) {
        this.twos = twos;
    }

    public void setThrees(int threes) {
        this.threes = threes;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public void setFives(int fives) {
        this.fives = fives;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public void setUpperBonus(boolean upperBonus) {
        this.upperBonus = upperBonus;
    }

    public void setUpperTotal(int upperTotal) {
        this.upperTotal = upperTotal;
    }

    public void setThreeOfAKind(int threeOfAKind) {
        this.threeOfAKind = threeOfAKind;
    }

    public void setFourOfAKind(int fourOfAKind) {
        this.fourOfAKind = fourOfAKind;
    }

    public void setFullHouse(int fullHouse) {
        this.fullHouse = fullHouse;
    }

    public void setSmallStraight(int smallStraight) {
        this.smallStraight = smallStraight;
    }

    public void setLargeStraight(int largeStraight) {
        this.largeStraight = largeStraight;
    }

    public void setYahtzee(int yahtzee) {
        Yahtzee = yahtzee;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public void setYahtzeeBonus(int yahtzeeBonus) {
        this.yahtzeeBonus = yahtzeeBonus;
    }

    public void setLowerTotal(int lowerTotal) {
        this.lowerTotal = lowerTotal;
    }

    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
