import enums.YahtzeeEnums;
import model.scoring.ScoreKeeper;
import model.scoring.UpdateStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScoreKeeperTest {

    ScoreKeeper scoreKeeper = new ScoreKeeper();


    @Test
    public void TestScoreKeeperUpper() {
        scoreKeeper.updateScore(15, YahtzeeEnums.Section.UPPER,YahtzeeEnums.UpperCategory.THREES );
        assertEquals(15, scoreKeeper.getUpperTotal());
        assertEquals(15, (int) scoreKeeper.getScore(YahtzeeEnums.Section.UPPER, YahtzeeEnums.UpperCategory.THREES));
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
        scoreKeeper.updateScore(30, YahtzeeEnums.Section.UPPER, YahtzeeEnums.UpperCategory.SIXES);
        scoreKeeper.updateScore(25, YahtzeeEnums.Section.UPPER, YahtzeeEnums.UpperCategory.FIVES);
        scoreKeeper.updateScore(20, YahtzeeEnums.Section.UPPER, YahtzeeEnums.UpperCategory.FOURS);

        assertEquals(110, scoreKeeper.getUpperTotal());
    }

    @Test
    public void TestCategoriesNotUsedMoreThanOnce(){
        scoreKeeper.updateScore(30, YahtzeeEnums.Section.UPPER, YahtzeeEnums.UpperCategory.SIXES);
        scoreKeeper.updateScore(30, YahtzeeEnums.Section.UPPER, YahtzeeEnums.UpperCategory.SIXES);

        assertEquals(30, scoreKeeper.getUpperTotal());
    }

    @Test
    public void TestCategoryReturnsSuccessStatus(){
        UpdateStatus status = scoreKeeper.updateScore(30, YahtzeeEnums.Section.UPPER,YahtzeeEnums.UpperCategory.SIXES);

        assertTrue(status.isSuccess());

    }
    @Test
    public void TestDuplicateCategoryReturnsErrorMessage(){
        UpdateStatus status = scoreKeeper.updateScore(30, YahtzeeEnums.Section.UPPER, YahtzeeEnums.UpperCategory.SIXES);
        UpdateStatus newStatus = scoreKeeper.updateScore(30, YahtzeeEnums.Section.UPPER, YahtzeeEnums.UpperCategory.SIXES);

        assertEquals("Score already entered for this category", newStatus.getErrorMessage());
    }
}
