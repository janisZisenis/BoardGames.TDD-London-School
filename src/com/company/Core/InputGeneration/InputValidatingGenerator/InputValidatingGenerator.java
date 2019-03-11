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
        Input input = getInput();

        while(isNotValid(input)) {
            alert();
            input = getInput();
        }

        return input;
    }

    private Input getInput() {
        return generator.generate();
    }

    private void alert() {
        validator.alert();
    }

    private boolean isNotValid(Input input) {
        return !validator.isValid(input);
    }
}
