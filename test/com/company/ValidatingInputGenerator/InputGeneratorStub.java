package com.company.ValidatingInputGenerator;

import com.company.UserInput;

public class InputGeneratorStub implements InputGenerator {

    private int count = 0;
    private UserInput[] userInputs;

    public UserInput generateInput() {
        return this.userInputs[count++];
    }

    public void setUserInputs(UserInput[] inputs) {
        this.userInputs = inputs;
    }
}
