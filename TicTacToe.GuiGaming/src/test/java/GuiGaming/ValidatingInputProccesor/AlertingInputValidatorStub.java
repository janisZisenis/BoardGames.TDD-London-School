package GuiGaming.ValidatingInputProccesor;

import GuiGaming.ValidatingInputProcessor.AlertingInputValidator;
import InputGeneration.Input.Input;

import java.util.Arrays;

public class AlertingInputValidatorStub implements AlertingInputValidator {

    private Input[] valids = {};

    public void setValidInputs(Input[] generated) {
        this.valids = generated;
    }

    public boolean isValid(Input input) {
        return Arrays.asList(valids).contains(input);
    }

    public void alertIsInvalid(Input input) {}
}
