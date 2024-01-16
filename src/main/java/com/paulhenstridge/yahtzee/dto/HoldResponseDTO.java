package com.paulhenstridge.yahtzee.dto;

import java.util.List;

public class HoldResponseDTO {
    private List<Boolean> holdList;

    public HoldResponseDTO(List<Boolean> holdList) {
        this.holdList = holdList;
    }

    public List<Boolean> getHoldList() {
        return holdList;
    }
}