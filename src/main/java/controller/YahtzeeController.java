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
                // get score from model, pass through with enum
                int score = game.getCategoryScore(YahtzeeEnums.Section.UPPER, category);
                viewModel.setScoreValues(score, (YahtzeeEnums.UpperCategory) category);
            }
        } else if ( category instanceof YahtzeeEnums.LowerCategory){
            YahtzeeEnums.LowerCategory lowerCategory = (YahtzeeEnums.LowerCategory) category;
            // handle lower category calls
            switch (lowerCategory){
                case THREE_OF_A_KIND:
                    boolean successTOAK = game.scoreThreeOfAKind();
                    if (successTOAK) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                    }
                        break;

                case FOUR_OF_A_KIND:
                    boolean successFOAK = game.scoreFourOfAKind();
                    if (successFOAK) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                    }
                    break;

                case FULL_HOUSE:
                    boolean successFH = game.scoreFullHouse();
                    if (successFH) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                    }
                    break;

                case SMALL_STRAIGHT:
                    boolean successSS = game.scoreSmallStraight();
                    if (successSS) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                    }
                    break;

                case LARGE_STRAIGHT:
                    boolean successLS = game.scoreLargeStraight();
                    if (successLS) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                    }
                    break;
                case YAHTZEE:
                    boolean successYZ = game.scoreYahtzee();
                    if (successYZ) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                    }
                    break;
                case CHANCE:
                    boolean successCH = game.scoreChance();
                    if (successCH) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                    }
            }

        }
    }
}
