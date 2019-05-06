package InputGeneration.InputGenerators.AlertingInputGenerator;

import InputGeneration.Input.Input;
import InputGeneration.InputGenerator;
import InputGeneration.InputGenerators.ValidatingInputGenerator.ValidatingInputGenerator;
import InputGeneration.InputValidatorImp.InputAlerter;
import InputGeneration.InputValidatorImp.InputValidator;

public class AlertingInputGenerator extends ValidatingInputGenerator {

    private final InputAlerter alerter;

    public AlertingInputGenerator(InputGenerator generator, InputValidator validator, InputAlerter alerter) {
        super(generator, validator);
        this.alerter = alerter;
    }

    public Input generate() {
        Input input = getInput();

        while(isInvalid(input)) {
            alertInvalid(input);
            input = getInput();
        }

        return input;
    }

    private void alertInvalid(Input input) {
        alerter.alert(input);
    }

}
