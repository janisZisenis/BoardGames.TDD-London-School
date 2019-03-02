package com.company.Core.InputGeneration.ValidatingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.Core.InputGeneration.InputValidator;

public class ValidatingInputGenerator implements InputGenerator {
    private final InputGenerator generator;
    private final InputValidator validator;

    public ValidatingInputGenerator(InputGenerator generator, InputValidator validator) {
        this.generator = generator;
        this.validator = validator;
    }

    public Input generateInput() {
        Input in = getInput();

        while(isNotValid(in)) {
            in = getInput();
        }

        return in;
    }

    private Input getInput() {
        return generator.generateInput();
    }

    private boolean isNotValid(Input in) {
        return !validator.isValid(in);
    }
}
