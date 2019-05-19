package Input2D;

import Input2D.Input.Input;

public class CountingGeneratorStub implements InputGenerator {
    private int count = 0;
    private Input[] inputs;

    public Input generate() {
        return this.inputs[count++];
    }

    public void setGeneratedInputs(Input[] inputs) {
        this.inputs = inputs;
    }
}
