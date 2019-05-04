package Bussiness.Players;

import Bussiness.Input.Input;

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
