package com.company.Core.InputGeneration.VerboseValidatingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;

import java.util.Arrays;

public class InputValidatorStub implements InputValidator {

    private Input[] valids = {};

    public void setValidInputs(Input[] generated) {
        this.valids = generated;
    }

    public boolean isValid(Input input) {
        return Arrays.asList(valids).contains(input);
    }

    public void alertIsInvalid(Input input) {}
}
