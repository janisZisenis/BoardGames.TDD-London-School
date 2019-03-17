package com.company.Core.InputGeneration.InputRule;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRule.InputRule;

import java.util.Arrays;

public class InputRuleStub implements InputRule {
    private Input[] valid = {};

    public boolean isValid(Input input) {
        return Arrays.asList(valid).contains(input);
    }

    public void setValidInputs(Input[] valid) {
        this.valid = valid;
    }
}
