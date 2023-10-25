package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class YahtzeeViewModel {
    private List<Integer> diceValues;
    private final PropertyChangeSupport support;

    public YahtzeeViewModel(List<Integer> diceValues){
        this.diceValues = diceValues;
        support = new PropertyChangeSupport(this);
    }

    public List<Integer> getDiceValues() {
        return diceValues;
    }

    public void setDiceValues(List<Integer> newDiceValues) {
        List<Integer> oldDiceValues = this.diceValues;
        this.diceValues = newDiceValues;
        support.firePropertyChange("diceValues", oldDiceValues, newDiceValues);
    }
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
