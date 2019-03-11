package com.company.Core.InputGeneration.ValidatingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputValidatingGenerator.InputGenerator;
import com.company.Core.InputGeneration.CompositeValidator.InputRule;

public class ValidatingInputGenerator implements InputGenerator {
    private final InputGenerator generator;
    private final InputRule validator;

    public ValidatingInputGenerator(InputGenerator generator, InputRule validator) {
        this.generator = generator;
        this.validator = validator;
    }

    public Input generate() {
        Input in = getInput();

        while(isNotValid(in)) {
            in = getInput();
        }

        return in;
    }

    private Input getInput() {
        return generator.generate();
    }

    private boolean isNotValid(Input in) {
        return !validator.validates(in);
    }
}
