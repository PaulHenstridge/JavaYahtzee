import model.Game;
import enums.YahtzeeEnums;
import model.dice.YahtzeeDiceController;
import model.scoring.Lower;
import model.scoring.ScoreKeeper;
import model.scoring.Upper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;

public class GameTest {
    private Game game;
    private YahtzeeDiceController mockDice;
    @Before
    public void setUp(){
        mockDice = Mockito.mock(YahtzeeDiceController.class);
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        Upper upper = new Upper();
        Lower lower = new Lower();
        game = new Game(mockDice, scoreKeeper, upper, lower);
    }


    @Test
    public void TestScoreUpper() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(1, 2, 5,5,5));
        boolean success = game.scoreUpper(YahtzeeEnums.UpperCategory.FIVES);
        assertTrue(success);
        assertEquals(15,game.getUpperScore());
    }

    @Test
    public void TestScoreThreeOfAKind() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(3, 3, 3, 4, 5));
        boolean success = game.scoreThreeOfAKind();
        assertTrue(success);
        assertEquals(18L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.THREE_OF_A_KIND));
    }
    @Test
    public void TestScoreThreeOfAKind2() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(5,5,6,6,6));
        boolean success2 = game.scoreThreeOfAKind();
        assertTrue(success2);
        assertEquals(28L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.THREE_OF_A_KIND));
    }

    @Test
    public void TestThreeOfAKindNoScore(){
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(1, 3, 3, 4, 5));
        boolean success = game.scoreThreeOfAKind();
        assertTrue(success);
        assertEquals(0L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.THREE_OF_A_KIND));

    }
    @Test
    public void TestScoreFourOfAKind() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(3, 3, 3, 3, 5));
        boolean success = game.scoreFourOfAKind();
        assertTrue(success);
        assertEquals(17L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.FOUR_OF_A_KIND) );
    }
    @Test
    public void TestScoreFourOfAKindNoScore() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(3, 2, 6, 3, 5));
        boolean success = game.scoreFourOfAKind();
        assertTrue(success);
        assertEquals(0L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.FOUR_OF_A_KIND) );
    }
        @Test
    public void TestScoreYahtzee() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(3, 3, 3, 3, 3));
            boolean success = game.scoreYahtzee();
            assertTrue(success);
            assertEquals(50L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.YAHTZEE) );
        }

    @Test
    public void TestScoreYahtzeeNoScore() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(3, 2, 6, 3, 5));
        boolean success = game.scoreYahtzee();
        assertTrue(success);
        assertEquals(0L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.YAHTZEE) );
    }
        @Test
    public void TestScoreFullHouse() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(3, 3, 3, 4, 4));
            boolean success = game.scoreFullHouse();
            assertTrue(success);
            assertEquals(25L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.FULL_HOUSE) );
        }
                @Test
    public void TestScoreFullHouseNoScore() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(3, 1, 3, 4, 4));
            boolean success = game.scoreFullHouse();
            assertTrue(success);
            assertEquals(0L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.FULL_HOUSE) );
        }

            @Test
    public void TestScoreSmallStraight() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(3, 2, 3, 4, 5));
                boolean success = game.scoreSmallStraight();
                assertTrue(success);
                assertEquals(30L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.SMALL_STRAIGHT) );
    }
    @Test
    public void TestScoreSmallStraightNoScore() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(3, 2, 3, 1, 5));
        boolean success = game.scoreSmallStraight();
        assertTrue(success);
        assertEquals(0L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.SMALL_STRAIGHT) );

    }

            @Test
    public void TestScoreLargeStraight() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(1,2, 3, 4, 5));
        boolean success = game.scoreLargeStraight();
        assertTrue(success);
        assertEquals(40L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.LARGE_STRAIGHT) );

            }
                     @Test
    public void TestScoreLargeStraightNoScore() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(1,2, 6, 4, 5));
         boolean success = game.scoreSmallStraight();
         assertTrue(success);
         assertEquals(0L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.SMALL_STRAIGHT) );

                     }

            @Test
    public void TestScoreChance() {
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(1,2, 6, 4, 5));
        boolean success = game.scoreChance();
        assertTrue(success);
        assertEquals(18L, (long) game.getScoreKeeper().getScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.CHANCE) );

            }

}