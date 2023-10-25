package view;

import java.beans.PropertyChangeListener;
import java.util.List;

public interface IViewManager extends PropertyChangeListener {
    void updateDiceValues(List<Integer> newDiceValues);
    void rollButtonClicked();
    void setDiceViewListener(ViewListener listener);

}
