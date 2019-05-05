package Domain.InputFieldGeneratorAdapter;

import Domain.Input.Input;
import Domain.Players.InputGenerator;

public class InputGeneratorStub implements InputGenerator {

    private Input generatedInput;

    public void setGeneratedInput(Input input) {
        this.generatedInput = input;
    }
    public Input generate() {
        return generatedInput;
    }

}
