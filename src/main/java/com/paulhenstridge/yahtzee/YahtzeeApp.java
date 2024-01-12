package com.paulhenstridge.yahtzee;

import com.paulhenstridge.yahtzee.controller.YahtzeeController;
import com.paulhenstridge.yahtzee.model.Game;
import com.paulhenstridge.yahtzee.model.IGame;
import com.paulhenstridge.yahtzee.model.dice.DiceController;
import com.paulhenstridge.yahtzee.model.scoring.Lower;
import com.paulhenstridge.yahtzee.model.scoring.ScoreKeeper;
import com.paulhenstridge.yahtzee.model.scoring.Upper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.paulhenstridge.yahtzee.view.*;

import java.util.Scanner;

@SpringBootApplication
public class YahtzeeApp {

    private static DiceController dice;
    private static ScoreKeeper scoreKeeper;
    private static Upper upper;
    private static Lower lower;
    private static IGame game;

    public static void main(String[] args) {
        // Initialize com.paulhenstridge.yahtzee.model components
        dice = new DiceController();
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
        // Initialize the com.paulhenstridge.yahtzee.view event handler
        IViewEventHandler eventHandler = new ViewEventHandler();

        // Initialize the GUI
        IGUIUpdater gui = new YahtzeeGUI(eventHandler);

        // Initialize the com.paulhenstridge.yahtzee.view com.paulhenstridge.yahtzee.model
        YahtzeeViewModel viewModel = new YahtzeeViewModel();

        // Initialize the dice com.paulhenstridge.yahtzee.model observer
        IViewModelObserver modelObserver = new ViewModelObserver( gui, viewModel);

        // set modelObserver as a listener on viewModel
        viewModel.addPropertyChangeListener(modelObserver);

        // Initialize the com.paulhenstridge.yahtzee.controller and pass the Game instance to it
        YahtzeeController controller = new YahtzeeController(game, viewModel);

        eventHandler.setViewListener(controller);
    }
}
