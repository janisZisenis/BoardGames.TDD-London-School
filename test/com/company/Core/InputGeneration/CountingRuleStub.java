package com.company.Core.InputGeneration;

import com.company.Core.InputGeneration.CompositeValidator.InputRule;
import com.company.Core.InputGeneration.Input.Input;

import java.util.Arrays;

public class CountingRuleStub implements InputRule {
    private Input[] valid = {};

    public boolean validates(Input input) {
        return Arrays.asList(valid).contains(input);
    }

    public void setValidInputs(Input[] valid) {
        this.valid = valid;
    }
}
