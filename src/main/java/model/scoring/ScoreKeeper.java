package model.scoring;

import model.YahtzeeEnums;

import java.util.EnumMap;
import java.util.Map;

public class ScoreKeeper {

    private Map<YahtzeeEnums.UpperCategory, Integer> upperScores = new EnumMap<>(YahtzeeEnums.UpperCategory.class);
    private Map<YahtzeeEnums.LowerCategory, Integer> lowerScores = new EnumMap<>(YahtzeeEnums.LowerCategory.class);
    private int upperScore = 0;
    private int lowerScore = 0;
    private boolean upperBonus = false;


    public UpdateStatus updateScore(int score, YahtzeeEnums.Section section, Enum<?> category) {
        UpdateStatus status = new UpdateStatus();
        if (section == YahtzeeEnums.Section.UPPER) {
            YahtzeeEnums.UpperCategory upperCategory = (YahtzeeEnums.UpperCategory) category;
            if (!upperScores.containsKey(upperCategory)) {
                upperScores.put(upperCategory, score);
                upperScore += score;
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
                lowerScore += score;
                status.setSuccess(true);
            } else {
                status.setSuccess(false);
                status.setErrorMessage("Score already entered for this category");
            }
        }
        return status;
    }

    private void checkForUpperBonus() {
        if (upperScore >= 63 && !upperBonus) {
            upperBonus = true;
            upperScore += 35;
        }
    }

    public int getUpperScore() {
        return upperScore;
    }

    public int getLowerScore() {
        return lowerScore;
    }

    public boolean isUpperBonus() {
        return upperBonus;
    }

    public Integer getScore(YahtzeeEnums.Section section, Enum<?> category) {
        return section == YahtzeeEnums.Section.UPPER ? upperScores.get(category) : lowerScores.get(category);
    }
}
