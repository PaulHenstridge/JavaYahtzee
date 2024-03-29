package com.paulhenstridge.yahtzee.model.scoring;

import com.paulhenstridge.yahtzee.enums.YahtzeeEnums;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

@Service
public class ScoreKeeper {

    private Map<YahtzeeEnums.UpperCategory, Integer> upperScores = new EnumMap<>(YahtzeeEnums.UpperCategory.class);
    private Map<YahtzeeEnums.LowerCategory, Integer> lowerScores = new EnumMap<>(YahtzeeEnums.LowerCategory.class);
    private EnumSet<YahtzeeEnums.UpperCategory> upperCategoriesRemaining = EnumSet.allOf(YahtzeeEnums.UpperCategory.class);
    private EnumSet<YahtzeeEnums.LowerCategory> lowerCategoriesRemaining = EnumSet.allOf(YahtzeeEnums.LowerCategory.class);


    private boolean upperBonus;
    private boolean lowerBonus;
    private int upperTotal = 0;
    private int lowerTotal = 0;
    private int grandTotal;


    public UpdateStatus updateScore(int score, YahtzeeEnums.Section section, Enum<?> category) {
        UpdateStatus status = new UpdateStatus();
        if (section == YahtzeeEnums.Section.UPPER) {
            YahtzeeEnums.UpperCategory upperCategory = (YahtzeeEnums.UpperCategory) category;
            if (!upperScores.containsKey(upperCategory)) {
                upperScores.put(upperCategory, score);
                upperTotal += score;
                this.checkForUpperBonus();
                upperCategoriesRemaining.remove(upperCategory);
                if (upperCategoriesRemaining.isEmpty()){
                    grandTotal += upperTotal;
                    //  conditional styles
                }
                status.setSuccess(true);
                checkForUpperBonus();
            } else {
                status.setSuccess(false);
                status.setErrorMessage("Score already entered for this category");
            }
        } else if (section == YahtzeeEnums.Section.LOWER) {
            YahtzeeEnums.LowerCategory lowerCategory = (YahtzeeEnums.LowerCategory) category;
            if (!lowerScores.containsKey(lowerCategory)) {
                lowerScores.put((YahtzeeEnums.LowerCategory) category, score);
                lowerTotal += score;
                lowerCategoriesRemaining.remove(lowerCategory);

//                this.checkForLowerBonus();

                if (lowerCategoriesRemaining.isEmpty()){
                    grandTotal += lowerTotal;
                    //  conditional styles
                }
                status.setSuccess(true);
            } else {
                status.setSuccess(false);
                status.setErrorMessage("Score already entered for this category");
            }
        }
        return status;
    }

    private void checkForUpperBonus() {
        if (upperTotal >= 63 && !upperBonus) {
            upperBonus = true;
            upperTotal += 35;
        }
    }

//    private void checkForLowerBonus(){
//        if (this.getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.YAHTZEE) > 0){
//
//        }
//    }

    public int getUpperTotal() {
        return upperTotal;
    }

    public int getLowerTotal() {
        return lowerTotal;
    }

    public int getGrandTotal(){
        return grandTotal;
    }

    public boolean isUpperBonus() {
        return upperBonus;
    }

    public boolean isLowerBonus() {
        return lowerBonus;
    }

    public void setLowerTotal(int lowerTotal) {
        this.lowerTotal = lowerTotal;
    }

    public void setLowerBonus(boolean lowerBonus) {
        this.lowerBonus = lowerBonus;
    }

    public Integer getScore(YahtzeeEnums.Section section, Enum<?> category) {
        return section == YahtzeeEnums.Section.UPPER ? upperScores.get(category) : lowerScores.get(category);
    }
}
