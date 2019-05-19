package Input2D.ValidInputGenerator;

import Input2D.Input.Input;
import Input2D.InputGenerator;

public class ValidInputGenerator implements InputGenerator {

    private final InputGenerator generator;
    private final InputValidator validator;
    private final InputAlerter alerter;

    public ValidInputGenerator(InputGenerator generator, InputValidator validator, InputAlerter alerter) {
        this.generator = generator;
        this.validator = validator;
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

    private Input getInput() {
        return generator.generate();
    }

    private boolean isInvalid(Input in) {
        return !validator.isValid(in);
    }

}
