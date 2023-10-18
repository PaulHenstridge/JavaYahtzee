package model;

import model.dice.Dice;
import model.scoring.Lower;
import model.scoring.ScoreKeeper;
import model.scoring.Upper;

public class Game {
    private Dice dice;
    private Lower lower;
    private Upper upper;
    private ScoreKeeper scoreKeeper;

    public Game() {
        dice = new Dice();
        lower = new Lower();
        upper = new Upper();
        scoreKeeper = new ScoreKeeper();
    }
}
