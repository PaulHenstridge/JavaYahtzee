package view;

import java.util.List;

public class YahtzeeViewModel {
    private List<Integer> diceValues;

    public YahtzeeViewModel(List<Integer> diceValues){
        this.diceValues = diceValues;
    }

    public List<Integer> getDiceValues() {
        return diceValues;
    }

    public void setDiceValues(List<Integer> diceValues) {
        this.diceValues = diceValues;
    }
}
