package enums;

public class YahtzeeEnums {

    public enum Section {
        UPPER, LOWER
    }

    public enum UpperCategory {
        ONES(1), TWOS(2), THREES(3), FOURS(4), FIVES(5), SIXES(6);

        private final int diceVal;

        UpperCategory(int diceVal) {
            this.diceVal = diceVal;
        }

        public int getDiceVal() {
            return diceVal;
        }
    }

    public enum LowerCategory {
        THREE_OF_A_KIND, FOUR_OF_A_KIND, FULL_HOUSE, SMALL_STRAIGHT, LARGE_STRAIGHT, YAHTZEE, CHANCE
    }
}
