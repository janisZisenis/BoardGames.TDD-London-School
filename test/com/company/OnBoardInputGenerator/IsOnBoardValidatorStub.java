package com.company.OnBoardInputGenerator;

import com.company.UserInput;

public class IsOnBoardValidatorStub implements IsOnBoardValidator {
    private int indexOfUserInputBeingOnBoard = 0;
    private int count = 0;

    public void setTimesUserInputIsNotOnBoard(int times) {
        this.indexOfUserInputBeingOnBoard = times;
    }

    public boolean isOnBoard(UserInput input) {
        return indexOfUserInputBeingOnBoard == count++;
    }
}
