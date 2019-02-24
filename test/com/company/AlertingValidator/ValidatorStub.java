package com.company.AlertingValidator;

import com.company.UserInput;

public class ValidatorStub implements Validator {

    private boolean userInputIsValid = false;

    public void setInputIsValid() {
        userInputIsValid = true;
    }

    public void setInputIsInvalid() {
        userInputIsValid = false;
    }

    public boolean isValid(UserInput input) {
        return userInputIsValid;
    }
}
