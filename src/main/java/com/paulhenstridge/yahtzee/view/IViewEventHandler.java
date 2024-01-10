package com.paulhenstridge.yahtzee.view;

import com.paulhenstridge.yahtzee.controller.ViewListener;

public interface IViewEventHandler {

    void rollButtonClicked();
    void setViewListener(ViewListener listener);
    void holdButtonClicked(int index);
    void scoreButtonClicked(Enum<?> category);

}
