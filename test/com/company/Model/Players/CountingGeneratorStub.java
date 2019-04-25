package com.company.Model.Players;

import com.company.Data.Input.Input;
import com.company.Model.Players.InputGenerator;

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
