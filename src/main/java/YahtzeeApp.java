import controller.YahtzeeController;
import model.Game;
import model.IGame;
import model.dice.DiceController;
import model.scoring.Lower;
import model.scoring.ScoreKeeper;
import model.scoring.Upper;
import view.*;

public class YahtzeeApp {


    public static void main(String[] args) {
        // Initialize model components
        DiceController dice = new DiceController(5);
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        Upper upper = new Upper();
        Lower lower = new Lower();

        // Initialize the Game (concrete implementation of IGame)
        IGame game = new Game(dice, scoreKeeper, upper, lower);

        // Initialize the view event handler
        IViewEventHandler eventHandler = new ViewEventHandler();

        // Initialize the GUI
        IGUIUpdater gui = new YahtzeeGUI(eventHandler);

        // Initialize the view model
        YahtzeeViewModel viewModel = new YahtzeeViewModel();

        // Initialize the dice model observer
        IViewModelObserver modelObserver = new ViewModelObserver( gui, viewModel);

        // set modelObserver as a listener on viewModel
        viewModel.addPropertyChangeListener(modelObserver);


        // Initialize the controller and pass the Game instance to it
        YahtzeeController controller = new YahtzeeController(game, viewModel);

        eventHandler.setViewListener(controller);

    }

}
