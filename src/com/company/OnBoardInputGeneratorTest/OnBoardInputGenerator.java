package com.company.OnBoardInputGeneratorTest;

import com.company.UserInput;

public class OnBoardInputGenerator {
    private InputGenerator generator;

    public OnBoardInputGenerator(InputGenerator generator, IsOnFieldValidator isOnFieldValidator) {
        this.generator = generator;
    }

    public UserInput generateInput() {
        UserInput in = generator.generateInput();

        return in;
    }
}
