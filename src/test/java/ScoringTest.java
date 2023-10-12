import org.junit.Test;
import static org.junit.Assert.*;

import Dice.YahtzeeDiceController;
import Scoring.Upper;

import java.util.Arrays;
import java.util.List;

public class ScoringTest {
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
    public void TestRunningTotal(){
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
    public void TestHasBonus(){
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

    }    @Test
    public void TestBonusAddedToTotal(){
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
}
