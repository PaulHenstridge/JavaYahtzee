package Scoring;

public class ScoreKeeper {

    private int upperScore = 0;
    private int lowerScore = 0;
    private boolean upperBonus = false;

    public enum Section {
        UPPER, LOWER
    }

    public void updateScore( int score, Section section){
        if ( section == Section.UPPER){
            upperScore += score;
            checkForUpperBonus();
        }else if (section == Section.LOWER){
            lowerScore+= score;
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
}
