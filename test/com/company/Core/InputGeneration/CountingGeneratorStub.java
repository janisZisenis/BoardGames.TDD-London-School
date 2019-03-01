package com.company.Core.InputGeneration;

public class CountingGeneratorStub implements InputGenerator {
    private int count = 0;
    private Input[] userInputs;

    public Input generateInput() {
        return this.userInputs[count++];
    }

    public void setUserInputs(Input[] inputs) {
        this.userInputs = inputs;
    }
}
