package com.paulhenstridge.yahtzee.view;

import com.paulhenstridge.yahtzee.enums.YahtzeeEnums;

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

    // TODO - refactor to use com.paulhenstridge.yahtzee.enums for property names.  may need additional enum set
    //  for dice and totals


    @Override // com.paulhenstridge.yahtzee.model observer
    public void propertyChange(PropertyChangeEvent evt) {
        String propName = evt.getPropertyName();

        if (propName == "diceValues"){
            List<Integer> newDiceValues = (List<Integer>) evt.getNewValue();
            guiUpdater.updateDiceValues(newDiceValues);
        }

        if (propName == "upperTotal"){
            int newUpperTotal = (Integer) evt.getNewValue();
            guiUpdater.updateUpperTotal(newUpperTotal);
        }
        if (propName == "lowerTotal"){
            int newLowerTotal = (Integer) evt.getNewValue();
            guiUpdater.updateLowerTotal(newLowerTotal);
        }
         if (propName == "grandTotal"){
             int newGrandTotal = (Integer) evt.getNewValue();
             guiUpdater.updateGrandTotal(newGrandTotal);
        }
         if (propName == "upperBonus"){
             boolean newUpperBonus = (boolean) evt.getNewValue();
             guiUpdater.updateBonus(YahtzeeEnums.Section.UPPER, newUpperBonus);
        }

         if (propName == "lowerBonus"){
             boolean newLowerBonus = (boolean) evt.getNewValue();
             guiUpdater.updateBonus(YahtzeeEnums.Section.LOWER, newLowerBonus);
        }

         if (propName == "holdList"){
             List<Boolean> newHoldList = (List<Boolean>) evt.getNewValue();
             guiUpdater.updateHoldButtons(newHoldList);
         }
         if (propName == "turnsRemaining"){
             boolean turnsRemaining = (boolean) evt.getNewValue();
//             guiUpdater.outOfRolls();  TODO - alert user in UI, styles...?
         }

        if (evt.getNewValue() instanceof Integer) {
            int score = (Integer) evt.getNewValue();
            Enum<?> category = null;
            try {
                // Attempt to convert propName to an UpperCategory enum constant
                category = YahtzeeEnums.UpperCategory.valueOf(propName);
            } catch (IllegalArgumentException e) {
                // handle exception - propName is not an UpperCategory
                try {
                    // Attempt to convert propName to a LowerCategory enum constant
                    category = YahtzeeEnums.LowerCategory.valueOf(propName);
                } catch (IllegalArgumentException e1) {
                    //  handle exception - propName is neither an UpperCategory nor a LowerCategory
                }
            }

            if (category instanceof YahtzeeEnums.UpperCategory) {
                guiUpdater.updateUpperScore(score, (YahtzeeEnums.UpperCategory) category);
            } else if (category instanceof YahtzeeEnums.LowerCategory) {
                guiUpdater.updateLowerScore(score, (YahtzeeEnums.LowerCategory) category);
            } else {
                // Handle case where propName doesn't match any category
            }


        }
    }
}