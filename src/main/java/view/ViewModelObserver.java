package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ViewModelObserver implements IViewModelObserver, PropertyChangeListener {
    private YahtzeeViewModel viewModel;
    private IGUIUpdater guiUpdater;

    public ViewModelObserver(IGUIUpdater guiUpdater, YahtzeeViewModel viewModel) {
        this.guiUpdater = guiUpdater;
        this.viewModel = viewModel;
    }

    // TODO - refactor to use enums for property names.  may need additional enum set
    //  for dice and totals


    @Override // model observer
    public void propertyChange(PropertyChangeEvent evt) {
        String propName = evt.getPropertyName();
        switch (propName) {
            case "diceValues":
                List<Integer> newDiceValues = (List<Integer>) evt.getNewValue();
                guiUpdater.updateDiceValues(newDiceValues);
                break;

            case "ones":
                if (evt.getNewValue() instanceof Integer) {
                    int newVal = (Integer) evt.getNewValue();
//                    guiUpdater.categoryScore(newVal);
                    // pass through the enum along with the score, and 1 method should do it...
                    // should be able to ge the enum from the switch condition
                }


        }

    }
}