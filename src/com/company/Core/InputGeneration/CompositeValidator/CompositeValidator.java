package com.company.Core.InputGeneration.CompositeValidator;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputValidator;

import java.util.LinkedList;

public class CompositeValidator {

    private LinkedList<InputValidator> validators = new LinkedList<InputValidator>();

    public boolean validate(Input input) {
        boolean isValid = true;

        for(int i = 0; validators.size() > i; i++) {
            InputValidator v = validators.get(i);
            isValid = isValid && v.isValid(input);
        }

        return isValid;
    }

    public void add(InputValidator validator) {
        validators.add(validator);
    }
}
