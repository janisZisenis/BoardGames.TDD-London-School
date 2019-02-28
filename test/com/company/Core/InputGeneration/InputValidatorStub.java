package com.company.Core.InputGeneration;

import java.util.Arrays;

public class InputValidatorStub implements InputValidator {

    private Input[] valid = {};

    public void setValidInputs(Input[] valid) {
        this.valid = valid;
    }

    public boolean isValid(Input input) {
        return Arrays.asList(valid).contains(input);
    }
}
