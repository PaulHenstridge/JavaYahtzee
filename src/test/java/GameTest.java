import model.Game;
import model.dice.YahtzeeDiceController;
import model.scoring.Lower;
import model.scoring.ScoreKeeper;
import model.scoring.Upper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;

public class GameTest {
    private Game game;
    @Before
    public void setUp(){
        YahtzeeDiceController mockDice = Mockito.mock(YahtzeeDiceController.class);
        when(mockDice.getDiceValues()).thenReturn(Arrays.asList(1, 2, 5,5,5));
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        Upper upper = new Upper();
        Lower lower = new Lower();
        game = new Game(mockDice, scoreKeeper, upper, lower);
    }


    @Test
    public void TestScoreUpper() {
        boolean success = game.scoreUpper(ScoreKeeper.UpperCategory.FIVES);
        assertTrue(success);
        assertEquals(15,game.getUpperScore());
    }
}