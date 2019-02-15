package com.company.OnBoardInputGeneratorTest;

import com.company.UserInput;

public class IsOnFieldValidatorStub implements IsOnFieldValidator {
    private int indexOfUserInputBeingOnField = 0;
    private int count = 0;

    public void setTimesUserInputIsNotOnField(int times) {
        this.indexOfUserInputBeingOnField = times;
    }

    public boolean isOnField(UserInput input) {
        return indexOfUserInputBeingOnField == count++;
    }
}
