package com.paulhenstridge.yahtzee.model.scoring;

public class UpdateStatus {
    private boolean success;
    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
