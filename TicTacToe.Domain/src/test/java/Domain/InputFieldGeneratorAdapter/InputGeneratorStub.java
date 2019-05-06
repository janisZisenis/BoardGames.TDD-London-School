package Domain.InputFieldGeneratorAdapter;

import InputGeneration.Input.Input;
import InputGeneration.InputGenerator;

public class InputGeneratorStub implements InputGenerator {

    private Input generatedInput;

    public void setGeneratedInput(Input input) {
        this.generatedInput = input;
    }
    public Input generate() {
        return generatedInput;
    }

}
