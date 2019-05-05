package GuiGaming.ValidatingInputProccesor;

import Domain.Input.Input;
import Domain.InputGenerators.AlertingInputGenerator.InputValidatorStub;

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
