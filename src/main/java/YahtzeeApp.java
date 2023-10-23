import controller.YahtzeeController;
import view.DiceViewManager;
import view.YahtzeeGUI;

import java.util.Arrays;
import java.util.List;

public class YahtzeeApp {
    private static List<Integer> initialDiceValues = Arrays.asList(1,1,1,1,1);

    public static void main(String[] args) {
        DiceViewManager viewManager = new DiceViewManager( initialDiceValues);
        YahtzeeController controller = new YahtzeeController();
        viewManager.setDiceViewListener(controller);
        new YahtzeeGUI(viewManager);  // Pass the viewManager to the GUI so it can call methods on it
    }

}
