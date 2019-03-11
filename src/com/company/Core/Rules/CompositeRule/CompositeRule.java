package com.company.Core.Rules.CompositeRule;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.CompositeValidator.InputRule;

import java.util.LinkedList;

public class CompositeRule implements InputRule {

    private final LinkedList<InputRule> validators = new LinkedList<InputRule>();

    public boolean validates(Input input) {
        boolean isValid = true;

        for(int i = 0; validators.size() > i; i++) {
            InputRule v = validators.get(i);
            isValid = isValid && v.validates(input);
        }

        return isValid;
    }

    public void add(InputRule validator) {
        validators.add(validator);
    }

}
