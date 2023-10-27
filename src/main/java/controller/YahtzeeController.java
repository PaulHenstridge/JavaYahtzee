package controller;

import enums.YahtzeeEnums;
import model.IGame;
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
    public void onHoldButtonClicked(int index) {
        game.toggleHoldButton(index);
    }


    @Override
    public void onScoreButtonClicked(Enum<?> category) {
        if (category instanceof YahtzeeEnums.UpperCategory) {
            boolean success = game.scoreUpper((YahtzeeEnums.UpperCategory) category);
            if (success) {
                // TODO - call method in viewModel that takes the enum
                // get score from model, pass through with enum
                int score = game.getCategoryScore(YahtzeeEnums.Section.UPPER, category);
                viewModel.setScoreValues(score, (YahtzeeEnums.UpperCategory) category);
            }
        } else if ( category instanceof YahtzeeEnums.LowerCategory){
            // handle lower category calls
        }
    }
}
