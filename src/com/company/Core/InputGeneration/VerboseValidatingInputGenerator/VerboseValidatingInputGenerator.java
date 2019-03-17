package com.company.Core.InputGeneration.VerboseValidatingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.ValidatingInputGenerator.InputGenerator;

public class VerboseValidatingInputGenerator implements InputGenerator {

    private final InputGenerator generator;
    private InputReferee referee;

    public VerboseValidatingInputGenerator(InputGenerator generator, InputReferee referee) {
        this.generator = generator;
        this.referee = referee;
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
        referee.alertIsInvalid(input);
    }

    private Input getInput() {
        return generator.generate();
    }

    private boolean isNotValid(Input input) {
        return !referee.isValid(input);
    }
}
