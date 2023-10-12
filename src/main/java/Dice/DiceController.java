package Dice;

import java.util.List;

public interface DiceController {

    void holdDice(int index);
    void releaseDice(int index);
    void rollDice();
    List<Integer> getDiceValues();
}
