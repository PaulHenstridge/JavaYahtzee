package view;

import controller.ViewListener;

public interface IViewEventHandler {

    void rollButtonClicked();
    void setViewListener(ViewListener listener);
    void holdButtonClicked(int index);
    void scoreButtonClicked(Enum<?> category);

}
