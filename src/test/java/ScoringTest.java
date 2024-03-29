import com.paulhenstridge.yahtzee.model.scoring.Lower;
import org.junit.Test;
import static org.junit.Assert.*;

import com.paulhenstridge.yahtzee.model.scoring.Upper;

import java.util.Arrays;
import java.util.List;

public class ScoringTest {
    List<Integer> roll1 = Arrays.asList(1,2,3,4,5);
    List<Integer> roll2 = Arrays.asList(5,5,5,5,5);
    List<Integer> roll3 = Arrays.asList(5,5,5,6,6);
    List<Integer> roll4 = Arrays.asList(1,1,2,5,6);
    List<Integer> roll5 = Arrays.asList(3,3,3,3,6);
    List<Integer> roll6 = Arrays.asList(1,3,4,5,6);
    Lower lowerScoring = new Lower();



    @Test
    public void TestCorrectlyScoreUpper(){
        //
        int target = 5;

        List<Integer> diceRoll = Arrays.asList(3,5,5,3,5);
        Upper upperScoring = new Upper();
        //Act
        int roundScore = upperScoring.calculateScore(diceRoll,target);

        //Assert
        assertEquals(roundScore,15 );
    }

    @Test
    public void TestThreeOfaKind(){
        //Arrange
        assertEquals(15, lowerScoring.checkNumberOfAKind(roll3, 3));
    }
    @Test
    public void TestThreeOfaKindFailing(){
        //Arrange
        assertNotEquals(15, lowerScoring.checkNumberOfAKind(roll4, 3));
        assertEquals(0, lowerScoring.checkNumberOfAKind(roll4, 3));
    }
    @Test
    public void TestFourOfaKind(){
        //Arrange
        assertEquals(12, lowerScoring.checkNumberOfAKind(roll5, 4));
    }
    @Test
    public void TestFourOfaKindFailing(){
        //Arrange
        assertNotEquals(15, lowerScoring.checkNumberOfAKind(roll6, 4));
        assertEquals(0, lowerScoring.checkNumberOfAKind(roll6, 4));
    }
    @Test
    public void TestFullHouse(){
        assertEquals(25, lowerScoring.checkFullHouse(roll3));
    }
    @Test
    public void TestFullHouseFailing(){
        assertEquals(0, lowerScoring.checkFullHouse(roll4));
    }
    @Test
    public void TestSmallStraight(){
        assertEquals(30, lowerScoring.checkSmallStraight(roll6));
    }
    @Test
    public void TestSmallStraightFailing(){
        assertEquals(0, lowerScoring.checkSmallStraight(roll2));
    }
    @Test
    public void TestLargeStraight(){
        assertEquals(40, lowerScoring.checkLargeStraight(roll1));
    }
    @Test
    public void TestLargeStraightFailing(){
        assertEquals(0, lowerScoring.checkLargeStraight(roll5));
    }
    @Test
    public void TestYahtzee(){
        assertEquals(50, lowerScoring.checkYahtzee(roll2));
    }
    @Test
    public void TestYahtzeeFailing(){
        assertNotEquals(50, lowerScoring.checkYahtzee(roll1));
    }

    @Test
    public void TestChance(){
        assertEquals(25, lowerScoring.checkChance(roll2));
    }
}
