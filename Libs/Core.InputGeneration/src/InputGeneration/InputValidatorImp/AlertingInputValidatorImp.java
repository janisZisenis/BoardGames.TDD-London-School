package InputGeneration.InputValidatorImp;

import InputGeneration.Input.Input;
import InputGeneration.InputGenerators.AlertingInputGenerator.AlertingInputValidator;

public class AlertingInputValidatorImp implements AlertingInputValidator {

    private final InputValidator validator;
    private final InputAlerter alerter;

    public AlertingInputValidatorImp(InputValidator validator, InputAlerter alerter) {
        this.validator = validator;
        this.alerter = alerter;
    }

    public boolean isValid(Input input) {
        return validator.isValid(input);
    }

    public void alertIsInvalid(Input input) {
        alerter.alert(input);
    }
}
