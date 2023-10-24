package controller;

import model.IGame;
import view.DiceViewListener;
import view.IDiceViewManager;
import view.YahtzeeViewModel;

import java.util.List;

public class YahtzeeController implements DiceViewListener {

    private IGame game;
    private YahtzeeViewModel viewModel;

    public YahtzeeController(IGame game, YahtzeeViewModel viewModel){
        this.game = game;
        this.viewModel = viewModel;

    }
    @Override
    public void onRollButtonClicked() {
        game.rollDice();
        List<Integer> newDice = game.getCurrentDice();
        viewModel.setDiceValues(newDice);
        System.out.println(viewModel.getDiceValues());
    }
    @Override
    public void onHoldButtonClicked() {

    }
}
