package com.paulhenstridge.yahtzee.controller;

public interface ViewListener {
    void onRollButtonClicked();
    void onHoldButtonClicked(int index);
    void onScoreButtonClicked(Enum<?> category);


}
