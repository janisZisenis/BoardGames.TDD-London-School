package com.company.Core.InputGeneration.ValidatingInputGenerator;

import com.company.Core.InputGeneration.Input;
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
        Input in = generator.generateInput();

        while(!validator.isValid(in)) {
            in = generator.generateInput();
        }

        return in;
    }
}
