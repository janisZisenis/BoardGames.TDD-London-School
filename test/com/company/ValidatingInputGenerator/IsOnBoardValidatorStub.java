package com.company.ValidatingInputGenerator;

import com.company.AlertingValidator.Validator;
import com.company.UserInput;

public class IsOnBoardValidatorStub implements Validator {
    private int indexOfUserInputBeingOnBoard = 0;
    private int count = 0;

    public void setTimesUserInputIsInvalid(int times) {
        this.indexOfUserInputBeingOnBoard = times;
    }

    public boolean isValid(UserInput input) {
        return indexOfUserInputBeingOnBoard == count++;
    }
}
