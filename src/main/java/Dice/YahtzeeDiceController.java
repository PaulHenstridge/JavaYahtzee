package Dice;

import java.util.ArrayList;
import java.util.List;

public class YahtzeeDiceController implements DiceController{
    private List<Dice> diceList = new ArrayList<>();
    private List<Boolean> holdList = new ArrayList<>();

    public YahtzeeDiceController(int diceCount) {
        for (int i = 0; i < diceCount; i++) {
            diceList.add(new Dice());
            holdList.add(false);
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
        for (Dice dice : diceList) {
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

    public List<Dice> getDiceList() {
        return diceList;
    }
}
