package Scoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lower {

    public int checkNumberOfAKind(List<Integer> diceRoll, Integer ofAKind) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each die value
        for (Integer value : diceRoll) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        // Check for a three-of-a-kind and calculate the score
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == ofAKind) {
                return entry.getKey() * ofAKind;
            }
        }

        return 0;  // Return 0 if there is no x-of-a-kind
    }

    public int checkYahtzee(List<Integer> diceRoll){
        if(diceRoll.stream().allMatch(num -> num.equals(diceRoll.get(0)))){
            return 50;
        }
        return 0;
    }

    public int checkFullHouse(List<Integer> diceRoll){
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (Integer value : diceRoll){
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0)+1);
        }
        boolean hasThreeOfAKind = false;
        boolean hasTwoOfAKind = false;

        for( Integer frequency : frequencyMap.values()){
            if (frequency == 3) {
                hasThreeOfAKind = true;
            } else if (frequency == 2) {
                hasTwoOfAKind = true;
            }
        }
        return (hasThreeOfAKind && hasTwoOfAKind) ? 25 : 0;

    }
}
