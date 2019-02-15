package com.company.OnBoardInputGeneratorTest;

import com.company.UserInput;

public class OnBoardInputGenerator {
    private InputGenerator generator;
    private IsOnFieldValidator validator;

    public OnBoardInputGenerator(InputGenerator generator, IsOnFieldValidator validator) {
        this.generator = generator;
        this.validator = validator;
    }

    public UserInput generateInput() {
        UserInput in = generator.generateInput();

        while(!validator.isOnField(in))
            in = generator.generateInput();

        return in;
    }
}
