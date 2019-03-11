package com.company.Core.Rules.CompositeRule;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.ValidatingInputGenerator.InputRule;

import java.util.LinkedList;

public class CompositeRule implements InputRule {

    private final LinkedList<InputRule> validators = new LinkedList<InputRule>();

    public boolean isValid(Input input) {
        boolean isValid = true;

        for(int i = 0; validators.size() > i; i++) {
            InputRule v = validators.get(i);
            isValid = isValid && v.isValid(input);
        }

        return isValid;
    }

    public void add(InputRule validator) {
        validators.add(validator);
    }

}
