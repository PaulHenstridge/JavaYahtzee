package controller;

import model.IGame;
import view.ViewListener;
import view.YahtzeeViewModel;

import java.util.List;

public class YahtzeeController implements ViewListener {

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
    }
    @Override
    public void onHoldButtonClicked() {

    }
}
