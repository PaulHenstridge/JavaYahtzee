package com.paulhenstridge.yahtzee.model.scoring;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Lower {


    public int checkNumberOfAKind(List<Integer> diceRoll, Integer ofAKind) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each die value
        for (Integer value : diceRoll) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        // Check for a three-of-a-kind and calculate the score
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() >= ofAKind) {
                int totalScore = 0;
                for(Integer value : diceRoll) {
                    totalScore += value;
                }
                return totalScore;
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

    private static boolean isStraight(Set<Integer> uniqueValues, int start, int end){
        for( int i = start; i<= end; i++){
            if(!uniqueValues.contains(i)){
                return false;
            }
        }
        return true;
    }

    public int checkSmallStraight(List<Integer> diceRoll){
        Set<Integer> uniqueValues = new HashSet<>(diceRoll);

        for( int i = 1; i<=3; i++){
            if( isStraight(uniqueValues, i, i+3)){
                return 30;
            }
        }
        return 0;
    }
    public int checkLargeStraight(List<Integer> diceRoll){
        Set<Integer> uniqueValues = new HashSet<>(diceRoll);

        for( int i = 1; i<=2; i++){
            if( isStraight(uniqueValues, i, i+4)){
                return 40;
            }
        }
        return 0;
    }

    public int checkChance(List<Integer> diceRoll){
        Integer total = 0;
        for(Integer die : diceRoll){
            total += die;
        }
        return total;
    }
}
