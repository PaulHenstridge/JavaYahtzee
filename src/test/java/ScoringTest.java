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
        //Arrange (roll3 correct, roll 4 wrong)
        assertEquals(15, lowerScoring.threeOfaKind(roll3));
        //Act

        //Assert
    }

}
