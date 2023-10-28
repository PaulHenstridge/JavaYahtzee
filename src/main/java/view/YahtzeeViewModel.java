package view;

import enums.YahtzeeEnums;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.List;

public class YahtzeeViewModel {
    private final PropertyChangeSupport support;
    private List<Integer> diceValues = Arrays.asList(1,1,1,1,1);

    private Integer ones;
    private Integer twos;
    private Integer threes;
    private Integer fours;
    private Integer fives;
    private Integer sixes;
    private boolean upperBonus;

    private int upperTotal;

    private Integer threeOfAKind;
    private Integer fourOfAKind;
    private Integer fullHouse;
    private Integer smallStraight;
    private Integer largeStraight;
    private Integer Yahtzee;
    private Integer chance;
    private int yahtzeeBonus;

    private int lowerTotal;
    private int grandTotal;


    public YahtzeeViewModel(){
        support = new PropertyChangeSupport(this);
    }

    public List<Integer> getDiceValues() {
        return diceValues;
    }

    public Integer getOnes() {
        return ones;
    }

    public Integer getTwos() {
        return twos;
    }

    public Integer getThrees() {
        return threes;
    }

    public Integer getFours() {
        return fours;
    }

    public Integer getFives() {
        return fives;
    }

    public Integer getSixes() {
        return sixes;
    }

    public boolean isUpperBonus() {
        return upperBonus;
    }

    public int getUpperTotal() {
        return upperTotal;
    }

    public Integer getThreeOfAKind() {
        return threeOfAKind;
    }

    public Integer getFourOfAKind() {
        return fourOfAKind;
    }

    public Integer getFullHouse() {
        return fullHouse;
    }

    public Integer getSmallStraight() {
        return smallStraight;
    }

    public Integer getLargeStraight() {
        return largeStraight;
    }

    public Integer getYahtzee() {
        return Yahtzee;
    }

    public Integer getChance() {
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

    public void setScoreValues(int score, YahtzeeEnums.UpperCategory category){
        // switch on upper category
        switch(category){
            case ONES:
                Integer oldVal1 =  this.getOnes();
                this.setOnes(score);
                support.firePropertyChange(category.name(),oldVal1, this.getOnes());
                break;

            case TWOS:
                Integer oldVal2 = this.getTwos();
                this.setTwos(score);
                support.firePropertyChange(category.name(),oldVal2, this.getTwos());
                break;

            case THREES:
                Integer oldVal3 = this.getThrees();
                this.setThrees(score);
                support.firePropertyChange(category.name(),oldVal3, this.getThrees());
                break;

            case FOURS:
                Integer oldVal4 = this.getFours();
                this.setFours(score);
                support.firePropertyChange(category.name(),oldVal4, this.getFours());
                break;

            case FIVES:
                Integer oldVal5 = this.getFives();
                this.setFives(score);
                support.firePropertyChange(category.name(),oldVal5, this.getFives());
                break;

            case SIXES:
                Integer oldVal6 = this.getSixes();
                this.setSixes(score);
                support.firePropertyChange(category.name(),oldVal6, this.getSixes());
        }
    }
    public void setScoreValues(int score, YahtzeeEnums.LowerCategory category){
        System.out.println("score: "+ score +" , category: "+ category);
        switch(category){
            case THREE_OF_A_KIND:
                Integer oldValTOAK= this.getThreeOfAKind();
                this.setThreeOfAKind(score);
                System.out.println("YVM169- old: "+ oldValTOAK + " new: " + this.getThreeOfAKind());
                support.firePropertyChange(category.name(),oldValTOAK, this.getThreeOfAKind());


                break;
            case FOUR_OF_A_KIND:
                Integer oldValFOAK= this.getFourOfAKind();
                this.setFourOfAKind(score);
                support.firePropertyChange(category.name(),oldValFOAK, this.getFourOfAKind());

                break;

            case FULL_HOUSE:
                Integer oldValFH= this.getFullHouse();
                this.setFullHouse(score);
                support.firePropertyChange(category.name(),oldValFH, this.getFullHouse());

                break;

            case SMALL_STRAIGHT:
                Integer oldValSS= this.getSmallStraight();
                this.setSmallStraight(score);
                support.firePropertyChange(category.name(),oldValSS, this.getSmallStraight());

                break;

            case LARGE_STRAIGHT:
                Integer oldValLS= this.getLargeStraight();
                this.setLargeStraight(score);
                support.firePropertyChange(category.name(),oldValLS, this.getLargeStraight());

                break;

            case YAHTZEE:
                Integer oldValYZ= this.getYahtzee();
                this.setYahtzee(score);
                support.firePropertyChange(category.name(),oldValYZ, this.getYahtzee());

                    break;
            case CHANCE:
                Integer oldValCH= this.getChance();
                this.setChance(score);
                support.firePropertyChange(category.name(),oldValCH, this.getChance());
        }
    }

    public void setUpperTotal(int newUpperTotal) {
        int prevTotal = this.getUpperTotal();
        this.upperTotal = newUpperTotal;
        support.firePropertyChange("upperTotal",prevTotal, upperTotal);
    }
    public void setLowerTotal(int newLowerTotal) {
        int prevTotal = this.getLowerTotal();
        this.lowerTotal = newLowerTotal;
        support.firePropertyChange("lowerTotal",prevTotal, lowerTotal);
    }


    private void setOnes(int ones) {
        this.ones = ones;
    }

    private void setTwos(int twos) {
        this.twos = twos;
    }

    private void setThrees(int threes) {
        this.threes = threes;
    }

    private void setFours(int fours) {
        this.fours = fours;
    }

    private void setFives(int fives) {
        this.fives = fives;
    }

    private void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public void setUpperBonus(boolean upperBonus) {
        this.upperBonus = upperBonus;
    }



    private void setThreeOfAKind(int threeOfAKind) {
        this.threeOfAKind = threeOfAKind;
    }

    private void setFourOfAKind(int fourOfAKind) {
        this.fourOfAKind = fourOfAKind;
    }

    private void setFullHouse(int fullHouse) {
        this.fullHouse = fullHouse;
    }

    private void setSmallStraight(int smallStraight) {
        this.smallStraight = smallStraight;
    }

    private void setLargeStraight(int largeStraight) {
        this.largeStraight = largeStraight;
    }

    public void setYahtzee(int yahtzee) {
        Yahtzee = yahtzee;
    }

    private void setChance(int chance) {
        this.chance = chance;
    }

    public void setYahtzeeBonus(int yahtzeeBonus) {
        this.yahtzeeBonus = yahtzeeBonus;
    }

//    public void setLowerTotal(int lowerTotal) {
//        this.lowerTotal = lowerTotal;
//    }

//    public void setGrandTotal(int grandTotal) {
//        this.grandTotal = grandTotal;
//    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
