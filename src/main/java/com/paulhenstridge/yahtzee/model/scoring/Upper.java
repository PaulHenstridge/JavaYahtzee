package com.paulhenstridge.yahtzee.model.scoring;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Upper {

    // Method to calculate and update the score for the current round
    public int calculateScore(List<Integer> diceValues, int target) {
        int total = 0;
        for (int value : diceValues) {
            if (value == target) {
                total += target;
            }
        }
        return total;
    }
}

