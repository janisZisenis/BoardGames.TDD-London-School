package com.company.Core.InputGeneration.CompositeValidator;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputValidator;

public class CompositeValidator {

    boolean isValid = true;
    InputValidator validator;

    CompositeValidator() {

    }

    public boolean validate(Input input) {
        if(validator == null)
            return true;

        return validator.isValid(input);
    }

    public void add(InputValidator validator) {
        isValid = false;
        this.validator = validator;
    }
}
