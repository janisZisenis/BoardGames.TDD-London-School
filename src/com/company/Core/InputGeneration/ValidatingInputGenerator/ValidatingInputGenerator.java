package com.company.Core.InputGeneration.ValidatingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;

public class ValidatingInputGenerator implements InputGenerator {
    private final InputGenerator generator;
    private final InputRule rule;

    public ValidatingInputGenerator(InputGenerator generator, InputRule rule) {
        this.generator = generator;
        this.rule = rule;
    }

    public Input generate() {
        Input in = getInput();

        while(isNotValid(in))
            in = getInput();

        return in;
    }

    private Input getInput() {
        return generator.generate();
    }

    private boolean isNotValid(Input in) {
        return !rule.isValid(in);
    }
}
