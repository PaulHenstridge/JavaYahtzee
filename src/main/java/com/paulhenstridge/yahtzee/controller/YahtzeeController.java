package com.paulhenstridge.yahtzee.controller;

import com.paulhenstridge.yahtzee.enums.YahtzeeEnums;
import com.paulhenstridge.yahtzee.model.IGame;
import com.paulhenstridge.yahtzee.view.YahtzeeViewModel;

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
        if (game.getTurnsRemaining() <= 0){
            viewModel.setTurnsRemaining(false);
        } else {
            game.rollDice();
            List<Integer> newDice = game.getCurrentDice();
            viewModel.setDiceValues(newDice);
        }
    }
    @Override
    public void onHoldButtonClicked(int index) {
        if (game.getTurnsRemaining() == 3){
           // todo - viewModel.something tell user they have to roll before they can hold
        } else {
            game.toggleHoldButton(index);
            List< Boolean> holdList = game.getHoldList();
            viewModel.setHoldList(holdList);
        }
    }


    @Override
    public void onScoreButtonClicked(Enum<?> category) {
        if (category instanceof YahtzeeEnums.UpperCategory) {
            boolean success = game.scoreUpper((YahtzeeEnums.UpperCategory) category);
            if (success) {
                // get score from com.paulhenstridge.yahtzee.model, pass through with enum
                int score = game.getCategoryScore(YahtzeeEnums.Section.UPPER, category);
                viewModel.setScoreValues(score, (YahtzeeEnums.UpperCategory) category);
                viewModel.setUpperTotal(game.getUpperTotal());
                this.checkForGrandTotal();

                viewModel.setUpperBonus(game.getUpperBonus());

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
                        viewModel.setLowerTotal(game.getLowerTotal());
                    }
                        break;

                case FOUR_OF_A_KIND:
                    boolean successFOAK = game.scoreFourOfAKind();
                    if (successFOAK) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                        viewModel.setLowerTotal(game.getLowerTotal());
                    }
                    break;

                case FULL_HOUSE:
                    boolean successFH = game.scoreFullHouse();
                    if (successFH) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                        viewModel.setLowerTotal(game.getLowerTotal());
                    }
                    break;

                case SMALL_STRAIGHT:
                    boolean successSS = game.scoreSmallStraight();
                    if (successSS) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                        viewModel.setLowerTotal(game.getLowerTotal());
                    }
                    break;

                case LARGE_STRAIGHT:
                    boolean successLS = game.scoreLargeStraight();
                    if (successLS) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                        viewModel.setLowerTotal(game.getLowerTotal());
                    }
                    break;
                case YAHTZEE:
                    //  if yahtzee already scored, call a yahtzee bonus, +100,else ...
                    Integer yahtzeeScore = game.getCategoryScore(YahtzeeEnums.Section.LOWER, YahtzeeEnums.LowerCategory.YAHTZEE);
                    if ( yahtzeeScore != null && yahtzeeScore >0 ){
                        game.scoreLowerBonus();
                        // method in viewModel to make UI changes
                        viewModel.setLowerBonus(true);
                        viewModel.setLowerTotal(game.getLowerTotal());

                    } else {
                        boolean successYZ = game.scoreYahtzee();
                        if (successYZ) {
                            int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                            viewModel.setScoreValues(score, lowerCategory);
                            viewModel.setLowerTotal(game.getLowerTotal());
                        }
                    }
                    break;

                case CHANCE:
                    boolean successCH = game.scoreChance();
                    if (successCH) {
                        int score = game.getCategoryScore(YahtzeeEnums.Section.LOWER, category);
                        viewModel.setScoreValues(score, lowerCategory);
                        viewModel.setLowerTotal(game.getLowerTotal());
                    }
            }
        }
        this.checkForGrandTotal();
        viewModel.setLowerBonus(game.getLowerBonus());

        game.clearHolds();
        viewModel.setHoldList(game.getHoldList());
        game.setTurnsRemaining(3);
    }

    private void checkForGrandTotal() {
        int grandTot = game.getGrandTotal();
        if (grandTot > 0) {
            viewModel.setGrandTotal(grandTot);
        }
    }

    private void setUpperBonus(boolean status){
        viewModel.setUpperBonus(status);
    }
}
// TODO - move duplicate logic out of the switch statement to the end of the method.
