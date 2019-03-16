package com.company.Core.InputGeneration.VerboseValidatingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.ValidatingInputGenerator.InputGenerator;

public class VerboseValidatingInputGenerator {

    private final InputGenerator generator;
    private InputValidator validator;

    public VerboseValidatingInputGenerator(InputGenerator generator, InputValidator validator) {
        this.generator = generator;
        this.validator = validator;
    }

    public Input generate() {
        Input input = getInput();

        while(isNotValid(input)) {
            alertInvalid(input);
            input = getInput();
        }

        return input;
    }

    private void alertInvalid(Input input) {
        validator.alertIsInvalid(input);
    }

    private Input getInput() {
        return generator.generate();
    }

    private boolean isNotValid(Input input) {
        return !validator.isValid(input);
    }
}
