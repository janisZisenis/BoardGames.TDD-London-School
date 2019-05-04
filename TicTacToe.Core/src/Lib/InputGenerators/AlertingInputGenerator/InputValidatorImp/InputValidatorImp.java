package Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp;

import Lib.Input.Input;
import Lib.InputGenerators.AlertingInputGenerator.InputValidator;

public class InputValidatorImp implements InputValidator {

    private InputRule rule;
    private final InputAlerter alerter;

    public InputValidatorImp(InputRule rule, InputAlerter alerter) {
        this.rule = rule;
        this.alerter = alerter;
    }

    public boolean isValid(Input input) {
        return rule.isValid(input);
    }

    public void alertIsInvalid(Input input) {
        alerter.alert(input);
    }
}
