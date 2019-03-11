package com.company.Core.InputGeneration;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputValidatingGenerator.InputGenerator;

public class CountingGeneratorStub implements InputGenerator {
    private int count = 0;
    private Input[] userInputs;

    public Input generate() {
        return this.userInputs[count++];
    }

    public void setGeneratedInputs(Input[] inputs) {
        this.userInputs = inputs;
    }
}
