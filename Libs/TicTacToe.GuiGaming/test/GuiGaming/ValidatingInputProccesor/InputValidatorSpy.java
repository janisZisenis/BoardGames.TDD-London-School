package GuiGaming.ValidatingInputProccesor;

import InputGeneration.Input.Input;
import InputGeneration.InputGenerators.AlertingInputGenerator.InputValidatorStub;

public class InputValidatorSpy extends InputValidatorStub {

    private Input alertedInput;
    private boolean didAlert = false;

    public void alertIsInvalid(Input input) {
        super.alertIsInvalid(input);
        didAlert = true;
        this.alertedInput = input;
    }
    public Input getAlertedInput() {
        return alertedInput;
    }

    public boolean hasAlerted() {
        return didAlert;
    }
}
