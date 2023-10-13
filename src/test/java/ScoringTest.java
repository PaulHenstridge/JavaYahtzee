import Scoring.Lower;
import org.junit.Test;
import static org.junit.Assert.*;

import Dice.YahtzeeDiceController;
import Scoring.Upper;

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
    public void TestUpperRunningTotal(){
        int target = 5;

        List<Integer> diceRoll = Arrays.asList(3,5,5,3,5);
        Upper upperScoring = new Upper();
        //Act
        upperScoring.calculateScore(diceRoll,target);
        upperScoring.calculateScore(diceRoll,target);
        //Assert
        assertEquals( 30, upperScoring.getTotal());

    }
    @Test
    public void TestUpperHasBonus(){
        int target = 6;

        List<Integer> diceRoll = Arrays.asList(6,6,6,6,6);
        Upper upperScoring = new Upper();
        //Act
        upperScoring.calculateScore(diceRoll,target);
        upperScoring.calculateScore(diceRoll,target);
        upperScoring.calculateScore(diceRoll,target);
        System.out.println(upperScoring.getTotal());
        //Assert
        assertTrue( upperScoring.hasBonus());

    }
    @Test
    public void TestUpperBonusAddedToTotal(){
        int target = 6;

        List<Integer> diceRoll = Arrays.asList(6,6,6,6,6);
        Upper upperScoring = new Upper();
        //Act
        upperScoring.calculateScore(diceRoll,target);
        upperScoring.calculateScore(diceRoll,target);
        upperScoring.calculateScore(diceRoll,target);
        System.out.println(upperScoring.getTotal());
        //Assert
        assertEquals( 125, upperScoring.getTotal());
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

    }
    @Test
    public void TestSmallStraight(){

    }
    @Test
    public void TestLargeStraight(){

    }
    @Test
    public void TestYahtzee(){
        assertEquals(50, lowerScoring.checkYahtzee(roll2));
    }
    @Test
    public void Failing(){
        assertNotEquals(50, lowerScoring.checkYahtzee(roll1));
    }

    @Test
    public void TestChance(){

    }

}
