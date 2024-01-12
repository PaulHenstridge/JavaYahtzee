package com.paulhenstridge.yahtzee.dto;

import com.paulhenstridge.yahtzee.enums.YahtzeeEnums;

public class ScoreDTO {
    // define enum
    private String category;
    private String section;


        // Constructor, getters, and setters
    public ScoreDTO() {}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
            this.category = category;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}

