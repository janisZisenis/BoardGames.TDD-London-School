package com.company.Core.InputGeneration.InputValidatingGenerator;

import com.company.Core.InputGeneration.Input.Input;

import java.util.Arrays;

public class CountingInputValidatorSpy implements InputValidator {
    private Input[] valids = {};
    private int timesAlerted = 0;

    public void setValidInputs(Input[] valids) {
        this.valids = valids;
    }

    public boolean isValid(Input input) {
        return Arrays.asList(valids).contains(input);
    }

    public void alert() {
        timesAlerted++;
    }

    public int getTimesAlerted() {
        return timesAlerted;
    }
}
