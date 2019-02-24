package com.company.Core.InputGeneration;

public class CountingValidatorStub implements InputValidator {
    private int indexOfUserInputBeingOnBoard = 0;
    private int count = 0;

    public void setTimesUserInputIsInvalid(int times) {
        this.indexOfUserInputBeingOnBoard = times;
    }

    public boolean isValid(Input input) {
        return indexOfUserInputBeingOnBoard == count++;
    }
}
