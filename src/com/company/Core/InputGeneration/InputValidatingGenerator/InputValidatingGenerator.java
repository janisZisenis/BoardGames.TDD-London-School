package com.company.Core.InputGeneration.InputValidatingGenerator;

import com.company.Core.InputGeneration.Input.Input;

public class InputValidatingGenerator {

    private final InputGenerator generator;
    private final InputValidator validator;

    public InputValidatingGenerator(InputGenerator generator, InputValidator validator) {
        this.generator = generator;
        this.validator = validator;
    }

    public Input generate() {
        Input input = generator.generate();

        while(!validator.isValid(input)) {
            validator.alert();
            input = generator.generate();
        }

        return input;
    }
}
