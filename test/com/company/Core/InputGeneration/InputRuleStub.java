package com.company.Core.InputGeneration;

import com.company.Core.InputGeneration.Input.Input;

import java.util.Arrays;

public class InputRuleStub implements InputRule {

    private Input[] valid = {};

    public void setValidInputs(Input[] valid) {
        this.valid = valid;
    }

    public boolean validates(Input input) {
        return Arrays.asList(valid).contains(input);
    }
}
