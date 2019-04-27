package Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp;

import Lib.Data.Input.Input;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputAlerterMock implements InputAlerter {

    private boolean expectedHasAlerted = false;
    private boolean actualHasAlerted = false;
    private Input expectedAlertedInput;
    private Input actualAlertedInput;

    public void verifyAll() {
        assertEquals(expectedHasAlerted, actualHasAlerted);
        assertEquals(expectedAlertedInput, actualAlertedInput);
    }

    public void expectAlertedInput(Input input) {
        this.expectedHasAlerted = true;
        this.expectedAlertedInput = input;
    }

    public void expectHasNotAlerted() {
        this.expectedHasAlerted = false;
    }

    public void alert(Input input) {
        actualHasAlerted = true;
        actualAlertedInput = input;
    }
}
