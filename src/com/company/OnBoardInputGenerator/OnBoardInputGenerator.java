package com.company.OnBoardInputGenerator;

import com.company.UserInput;

public class OnBoardInputGenerator {
    private InputGenerator generator;
    private IsOnBoardValidator validator;

    public OnBoardInputGenerator(InputGenerator generator, IsOnBoardValidator validator) {
        this.generator = generator;
        this.validator = validator;
    }

    public UserInput generateInput() {
        UserInput in = generator.generateInput();

        while(!validator.isOnBoard(in)) {
            in = generator.generateInput();
        }

        return in;
    }
}
