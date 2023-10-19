package model;

import model.dice.Dice;
import model.dice.YahtzeeDiceController;
import model.scoring.Lower;
import model.scoring.ScoreKeeper;
import model.scoring.UpdateStatus;
import model.scoring.Upper;

import java.util.List;

public class Game {
    private YahtzeeDiceController dice;
    private Lower lower;
    private Upper upper;
    private ScoreKeeper scoreKeeper;


    public Game(YahtzeeDiceController dice, ScoreKeeper scoreKeeper, Upper upper, Lower lower) {
        this.dice = dice;
        this.lower = lower;
        this.upper = upper;
        this.scoreKeeper = scoreKeeper;
    }

    public boolean scoreUpper(YahtzeeEnums.UpperCategory category){
        int diceVal = category.getDiceVal();
        int score = upper.calculateScore(dice.getDiceValues(), diceVal);
        UpdateStatus status = scoreKeeper.updateScore(score,YahtzeeEnums.Section.UPPER, category);
        return status.isSuccess();
    }

    public int getUpperScore(){
        return scoreKeeper.getUpperScore();
    }

}
//This Game class acts as a bridge,
// encapsulating the game logic and providing a clean,
// high-level API for the GameController to interact with.
// This way, the GameController doesn't need to know the details of
// how scoring or dice rolling is implemented;
// it just needs to call the appropriate methods on the Game object.
