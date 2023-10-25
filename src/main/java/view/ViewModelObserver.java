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


    @Override // model observer
    public void propertyChange(PropertyChangeEvent evt) {
        if ("diceValues".equals(evt.getPropertyName())) {
            List<Integer> newDiceValues = (List<Integer>) evt.getNewValue();
            guiUpdater.updateDiceValues(newDiceValues);
        }
    }
}
