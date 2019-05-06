package InputGeneration.InputGenerators.AlertingInputGenerator;

import InputGeneration.Input.Input;
import InputGeneration.InputGenerator;

public class AlertingInputGenerator implements InputGenerator {

    private final InputGenerator generator;
    private AlertingInputValidator validator;

    public AlertingInputGenerator(InputGenerator generator, AlertingInputValidator validator) {
        this.generator = generator;
        this.validator = validator;
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
        validator.alertIsInvalid(input);
    }

    private Input getInput() {
        return generator.generate();
    }

    private boolean isInvalid(Input input) {
        return !validator.isValid(input);
    }

}
