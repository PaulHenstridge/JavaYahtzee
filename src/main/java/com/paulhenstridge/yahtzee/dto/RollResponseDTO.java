package com.paulhenstridge.yahtzee.dto;

import java.util.List;

public class RollResponseDTO {
    private int turnsRemaining;
    List<Integer> dice;

    public RollResponseDTO(int turnsRemaining, List<Integer> dice){
        this.turnsRemaining = turnsRemaining;
        this.dice = dice;
    }

    public int getTurnsRemaining() {
        return turnsRemaining;
    }

    public List<Integer> getDice() {
        return dice;
    }
}
