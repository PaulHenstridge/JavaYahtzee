package controller;

import model.IGame;
import view.DiceViewListener;
import view.IDiceViewManager;

import java.util.List;

public class YahtzeeController implements DiceViewListener {

    private IGame game;
    private IDiceViewManager diceViewManager;

    public YahtzeeController(IGame game, IDiceViewManager diceViewManager){
        this.game = game;
        this.diceViewManager = diceViewManager;

    }
    @Override
    public void onRollButtonClicked() {
        game.rollDice();
        List<Integer> newDice = game.getCurrentDice();
        diceViewManager.updateDiceValues(newDice);
        System.out.println(diceViewManager.getDiceValues());

    }
    @Override
    public void onHoldButtonClicked() {

    }
}
