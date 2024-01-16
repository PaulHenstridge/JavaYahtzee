package com.paulhenstridge.yahtzee.dto;

public class ScoreResponseDTO {

    private String category;
    private int score;
    private int upperTotal;
    private int lowerTotal;

    public ScoreResponseDTO(String category, int score, int upperTotal, int lowerTotal) {
        this.category = category;
        this.score = score;
        this.upperTotal = upperTotal;
        this.lowerTotal = lowerTotal;
    }

    // Getters
    public int getScore() {
        return score;
    }

    public String getCategory() {
        return category;
    }
    public int getUpperTotal() {
        return upperTotal;
    }

    public int getLowerTotal() {
        return lowerTotal;
    }

}

