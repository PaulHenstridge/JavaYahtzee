import controller.YahtzeeController;
import model.Game;
import model.IGame;
import model.dice.DiceController;
import model.scoring.Lower;
import model.scoring.ScoreKeeper;
import model.scoring.Upper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import view.*;

import java.util.Scanner;

@SpringBootApplication
public class YahtzeeApp {

    private static DiceController dice;
    private static ScoreKeeper scoreKeeper;
    private static Upper upper;
    private static Lower lower;
    private static IGame game;

    public static void main(String[] args) {
        // Initialize model components
        dice = new DiceController(5);
        scoreKeeper = new ScoreKeeper();
        upper = new Upper();
        lower = new Lower();

        // Initialize the Game (concrete implementation of IGame)
        game = new Game(dice, scoreKeeper, upper, lower);

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select mode: 1 for GUI, 2 for Web API");
        int mode = scanner.nextInt();

        if (mode == 1) {
            // Launch GUI
            launchGUI(game);
        } else if (mode == 2) {
            // Launch Spring Boot application
            SpringApplication.run(YahtzeeApp.class, args);
        } else {
            System.out.println("Please press 1 or 2 to continue");
        }
    }


    private static void launchGUI(IGame game){
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
