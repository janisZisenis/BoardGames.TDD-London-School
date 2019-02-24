package com.company.Core.InputGeneration;

public class ValidatorStub implements InputValidator {

    private boolean userInputIsValid = false;

    public void setInputIsValid() {
        userInputIsValid = true;
    }

    public void setInputIsInvalid() {
        userInputIsValid = false;
    }

    public boolean isValid(Input input) {
        return userInputIsValid;
    }
}
