import org.junit.Test;
import static org.junit.Assert.*;

import Dice.Dice;

public class DiceTest {

    @Test
    public void TestCanRollSingleDie() {
        Dice Dice = new Dice();
        for (int i = 0; i < 1000; i++) {
            int roll = Dice.roll();
            assertTrue("Roll out of bounds: " + roll, roll >= 1 && roll <= 6);
        }
    }

    @Test
    public void TestCanRollFiveDice() {
        // Arrange
        // ... code to set up test scenario ...

        // Act
        // ... code to invoke the behavior to test ...

        // Assert
        // ... code to check the result ...
    }
    @Test
    public void TestDiceCanBeHeld() {
        // Arrange
        // ... code to set up test scenario ...

        // Act
        // ... code to invoke the behavior to test ...

        // Assert
        // ... code to check the result ...

    }
    @Test
    public void TestDiceCanBeUnheld() {
        // Arrange
        // ... code to set up test scenario ...

        // Act
        // ... code to invoke the behavior to test ...

        // Assert
        // ... code to check the result ...
    }
}