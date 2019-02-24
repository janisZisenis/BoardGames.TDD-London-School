package com.company.ValidatingInputGenerator;

import com.company.AlertingValidator.Validator;
import com.company.UserInput;

public class ValidatingInputGenerator implements InputGenerator {
    private InputGenerator generator;
    private Validator validator;

    public ValidatingInputGenerator(InputGenerator generator, Validator validator) {
        this.generator = generator;
        this.validator = validator;
    }

    public UserInput generateInput() {
        UserInput in = generator.generateInput();

        while(!validator.isValid(in)) {
            in = generator.generateInput();
        }

        return in;
    }
}
