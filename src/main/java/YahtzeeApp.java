import controller.YahtzeeController;
import model.Game;
import model.IGame;
import model.dice.YahtzeeDiceController;
import model.scoring.Lower;
import model.scoring.ScoreKeeper;
import model.scoring.Upper;
import view.DiceViewManager;
import view.IDiceViewManager;
import view.YahtzeeGUI;
import view.YahtzeeViewModel;

import java.util.Arrays;
import java.util.List;

public class YahtzeeApp {
    private static List<Integer> initialDiceValues = Arrays.asList(1,1,1,1,1);

    public static void main(String[] args) {
        // Initialize model components
        YahtzeeDiceController dice = new YahtzeeDiceController(5);
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        Upper upper = new Upper();
        Lower lower = new Lower();

        // Initialize the Game (concrete implementation of IGame)
        IGame game = new Game(dice, scoreKeeper, upper, lower);

        // Initialize the view model
        YahtzeeViewModel viewModel = new YahtzeeViewModel(initialDiceValues);
        // Initialize the dice view manager
        IDiceViewManager diceViewManager = new DiceViewManager( viewModel);


        // Initialize the controller and pass the Game instance to it
        YahtzeeController controller = new YahtzeeController(game, viewModel);

        diceViewManager.setDiceViewListener(controller);

        new YahtzeeGUI(diceViewManager);  // Pass the viewManager to the GUI so it can call methods on it
    }

}
