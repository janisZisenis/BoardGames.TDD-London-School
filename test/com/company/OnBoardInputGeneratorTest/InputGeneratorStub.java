package com.company.OnBoardInputGeneratorTest;

import com.company.UserInput;

public class InputGeneratorStub implements InputGenerator {

    private UserInput userInput;

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }

    public UserInput generateInput() {
        return this.userInput;
    }
}
