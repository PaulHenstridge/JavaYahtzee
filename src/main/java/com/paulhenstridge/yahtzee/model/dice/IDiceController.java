package com.paulhenstridge.yahtzee.model.dice;

import java.util.List;

public interface IDiceController {

    void toggleHold(int index);

    void holdDice(int index);
    void releaseDice(int index);
    void rollDice();
    List<Integer> getDiceValues();
}
