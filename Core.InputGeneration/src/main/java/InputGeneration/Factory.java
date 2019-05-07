package InputGeneration;

import InputGeneration.CompositeInputValidator.CompositeInputValidator;
import InputGeneration.ValidInputGenerator.InputAlerter;
import InputGeneration.ValidInputGenerator.InputValidator;
import InputGeneration.ValidInputGenerator.NullInputAlerter;
import InputGeneration.ValidInputGenerator.ValidInputGenerator;

public abstract class Factory {

    public static CompositeInputValidator makeCompositeInputValidator() {
        return new CompositeInputValidator();
    }

    public static InputGenerator makeAlertingInputGenerator(InputGenerator generator, InputValidator validator, InputAlerter alerter) {
        return new ValidInputGenerator(generator, validator, alerter);
    }

    public static InputGenerator makeValidatingInputGenerator(InputGenerator generator, InputValidator validator) {
        InputAlerter alerter = new NullInputAlerter();
        return makeAlertingInputGenerator(generator, validator, alerter);
    }

}
