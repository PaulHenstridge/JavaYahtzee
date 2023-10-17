import model.scoring.ScoreKeeper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreKeeperTest {

    ScoreKeeper scoreKeeper = new ScoreKeeper();


    @Test
    public void TestScoreKeeperUpper() {
        scoreKeeper.updateScore(15, ScoreKeeper.Section.UPPER,ScoreKeeper.UpperCategory.THREES );
        assertEquals(15, scoreKeeper.getUpperScore());
        assertEquals(15, (int) scoreKeeper.getScore(ScoreKeeper.Section.UPPER, ScoreKeeper.UpperCategory.THREES));
    }
//    @Test
//    public void TestScoreKeeperUpperWithBonus() {
//        scoreKeeper.updateScore(65, ScoreKeeper.Section.UPPER,);
//        assertEquals(100, scoreKeeper.getUpperScore());
//    }
//    @Test
//    public void TestScoreKeeperLower() {
//        scoreKeeper.updateScore(30, ScoreKeeper.Section.LOWER);
//        assertEquals(30, scoreKeeper.getLowerScore());
//    }

    @Test
    public void TestUpperBonusAddedToTotal(){
        scoreKeeper.updateScore(30, ScoreKeeper.Section.UPPER, ScoreKeeper.UpperCategory.SIXES);
        scoreKeeper.updateScore(25, ScoreKeeper.Section.UPPER, ScoreKeeper.UpperCategory.FIVES);
        scoreKeeper.updateScore(20, ScoreKeeper.Section.UPPER, ScoreKeeper.UpperCategory.FOURS);

        assertEquals(110, scoreKeeper.getUpperScore());
    }

    @Test
    public void TestCategoriesNotUsedMoreThanOnce(){
        scoreKeeper.updateScore(30, ScoreKeeper.Section.UPPER, ScoreKeeper.UpperCategory.SIXES);
        scoreKeeper.updateScore(30, ScoreKeeper.Section.UPPER, ScoreKeeper.UpperCategory.SIXES);

        assertEquals(30, scoreKeeper.getUpperScore());
    }
}
