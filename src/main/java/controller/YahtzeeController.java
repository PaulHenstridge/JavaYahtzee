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
            YahtzeeEnums.UpperCategory upperCategory = (YahtzeeEnums.UpperCategory) category;
            boolean success = game.scoreUpper((YahtzeeEnums.UpperCategory) category);
            if (success) {
                System.out.println(game.getCategoryScore(YahtzeeEnums.Section.UPPER, category));
                System.out.println(game.getUpperScore());
            }
        } else if ( category instanceof YahtzeeEnums.LowerCategory){
            // handle lower category calls
        }
    }
}
