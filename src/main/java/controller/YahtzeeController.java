package controller;

import view.DiceViewListener;

public class YahtzeeController implements DiceViewListener {
    @Override
    public void onRollButtonClicked() {
        System.out.println("Clickity click click");
    }
    @Override
    public void onHoldButtonClicked() {

    }
}
