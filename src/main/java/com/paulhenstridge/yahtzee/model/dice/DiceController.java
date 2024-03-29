package com.paulhenstridge.yahtzee.model.dice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiceController implements IDiceController {
    private List<Die> diceList = new ArrayList<>();
    private List<Boolean> holdList = new ArrayList<>();
    private int diceCount = 5;

    public DiceController() {
        for (int i = 0; i < diceCount; i++) {
            diceList.add(new Die());
            holdList.add(false);
        }
    }
    @Override
    public void toggleHold(int index){
        if(holdList.get(index)){
            holdList.set(index, false);
        } else {
            if (!holdList.get(index)){
                holdList.set(index, true);
            }
        }
    }

    @Override
    public void holdDice(int index) {
        holdList.set(index, true);
    }

    @Override
    public void releaseDice(int index) {
        holdList.set(index, false);
    }

    @Override
    public void rollDice() {
        for (int i = 0; i < diceList.size(); i++) {
            if (!holdList.get(i)) {
                diceList.get(i).roll();
            }
        }
    }

    public List<Integer> getDiceValues() {
        List<Integer> values = new ArrayList<>();
        for (Die dice : diceList) {
            values.add(dice.getValue());
        }
        return values;
    }

    public void resetHolds() {
        for (int i = 0; i < holdList.size(); i++) {
            holdList.set(i, false);
        }
    }

    public List<Boolean> getHoldList() {
        return holdList;
    }

    public List<Die> getDiceList() {
        return diceList;
    }
}
