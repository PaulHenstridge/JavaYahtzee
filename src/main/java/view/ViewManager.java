package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ViewManager implements IViewManager, PropertyChangeListener {
    private ViewListener listener;
    private YahtzeeViewModel viewModel;

    public ViewManager(YahtzeeViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void updateDiceValues(List<Integer> newDiceValues) {
//        viewModel.setDiceValues(newDiceValues);
    }

    @Override
    public void rollButtonClicked() {
        if (listener != null) {
            listener.onRollButtonClicked();
        }
    }

    @Override
    public void setDiceViewListener(ViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt);
        if ("diceValues".equals(evt.getPropertyName())) {
            updateDiceValues((List<Integer>) evt.getNewValue());
        }
    }

}


