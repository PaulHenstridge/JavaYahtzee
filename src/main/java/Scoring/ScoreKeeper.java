package Scoring;

import java.util.EnumMap;
import java.util.Map;

public class ScoreKeeper {

    private Map<UpperCategory, Integer> upperScores = new EnumMap<>(UpperCategory.class);
    private Map<LowerCategory, Integer> lowerScores = new EnumMap<>(LowerCategory.class);
    private int upperScore = 0;
    private int lowerScore = 0;
    private boolean upperBonus = false;

    public enum Section {
        UPPER, LOWER
    }

    public enum UpperCategory {
        ONES, TWOS, THREES, FOURS, FIVES, SIXES
    }

    public enum LowerCategory {
        THREE_OF_A_KIND, FOUR_OF_A_KIND, FULL_HOUSE, SMALL_STRAIGHT, LARGE_STRAIGHT, YAHTZEE, CHANCE
    }

    public void updateScore(int score, Section section, Enum<?> category) {
        if (section == Section.UPPER) {
            upperScores.put((UpperCategory) category, score);
            upperScore += score;
            checkForUpperBonus();
        } else if (section == Section.LOWER) {
            lowerScores.put((LowerCategory) category, score);
            lowerScore += score;
        }
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

    public Integer getScore(Section section, Enum<?> category) {
        return section == Section.UPPER ? upperScores.get(category) : lowerScores.get(category);
    }
}
