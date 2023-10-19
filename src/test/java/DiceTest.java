import org.junit.Test;
import static org.junit.Assert.*;

import model.dice.Dice;
import model.dice.YahtzeeDiceController;

import java.util.List;

public class DiceTest {

    @Test
    public void TestCanRollSingleDie() {
        // Arrange
        Dice Dice = new Dice();
        // Act
        for (int i = 0; i < 1000; i++) {
            Dice.roll();
            int roll = Dice.getValue();
            // Assert
            assertTrue("Roll out of bounds: " + roll, roll >= 1 && roll <= 6);
        }
    }

    @Test
    public void TestCanRollFiveDice() {
        // Arrange
        YahtzeeDiceController YahtzeeDice = new YahtzeeDiceController(5);

        // Act
        for (int i = 0; i < 100; i++) {
            YahtzeeDice.rollDice();
            List<Integer> result = YahtzeeDice.getDiceValues();
            // Assert
            assertTrue(result.size() == 5);
        }
    }

    @Test
    public void TestDiceCanBeHeld() {
        // Arrange
        YahtzeeDiceController YahtzeeDice = new YahtzeeDiceController(5);

        //Act
        for (int i = 0; i < 100; i++) {
            YahtzeeDice.resetHolds();
            YahtzeeDice.rollDice();
            YahtzeeDice.holdDice(0);
            YahtzeeDice.holdDice(1);
            Integer firstHeldVal = YahtzeeDice.getDiceValues().get(0);
            Integer secondHeldVal = YahtzeeDice.getDiceValues().get(1);
            YahtzeeDice.rollDice();
            List<Integer> result = YahtzeeDice.getDiceValues();
            Integer firstRetainedVal = YahtzeeDice.getDiceValues().get(0);
            Integer secondRetainedVal = YahtzeeDice.getDiceValues().get(1);

            // Assert
            assertTrue(firstHeldVal == firstRetainedVal && secondHeldVal == secondRetainedVal);
        }
    }

    @Test
    public void TestDiceCanBeUnheld() {
        // Arrange
        YahtzeeDiceController YahtzeeDice = new YahtzeeDiceController(5);

        //Act
        for (int i = 0; i < 100; i++) {
            YahtzeeDice.resetHolds();
            YahtzeeDice.rollDice();
            List<Dice> currentDice = YahtzeeDice.getDiceList();
            for (int j = 0; j < currentDice.size(); j++) {
                YahtzeeDice.holdDice(j);
            }
            List<Integer> firstSpin = YahtzeeDice.getDiceValues();
            YahtzeeDice.rollDice();

            // Assert
            assertNotSame(firstSpin, YahtzeeDice.getDiceValues());

        }
    }
}