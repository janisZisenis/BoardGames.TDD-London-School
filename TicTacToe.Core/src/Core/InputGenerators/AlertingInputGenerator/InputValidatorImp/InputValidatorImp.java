package Core.InputGenerators.AlertingInputGenerator.InputValidatorImp;

import Core.Input.Input;
import Core.InputGenerators.AlertingInputGenerator.InputValidator;

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
