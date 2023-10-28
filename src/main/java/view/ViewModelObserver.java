package view;

import enums.YahtzeeEnums;

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

        if (propName == "diceValues"){
            List<Integer> newDiceValues = (List<Integer>) evt.getNewValue();
            guiUpdater.updateDiceValues(newDiceValues);
        }

        if (propName == "upperTotal"){
            int newUpperScore = (Integer) evt.getNewValue();
            guiUpdater.updateUpperTotal(newUpperScore);
        }
        if (propName == "lowerTotal"){
            int newLowerScore = (Integer) evt.getNewValue();
            guiUpdater.updateLowerTotal(newLowerScore);
        }
         if (propName == "grandTotal"){
            // handle updating upper total
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
                System.out.println("firing upDateLower from VMO");
                guiUpdater.updateLowerScore(score, (YahtzeeEnums.LowerCategory) category);
            } else {
                // Handle case where propName doesn't match any category
            }


        }
    }
}