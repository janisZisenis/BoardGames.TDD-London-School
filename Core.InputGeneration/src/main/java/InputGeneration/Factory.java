package InputGeneration;

import InputGeneration.CompositeInputValidator.CompositeInputValidator;
import InputGeneration.ValidInputGenerator.InputAlerter;
import InputGeneration.ValidInputGenerator.InputValidator;
import InputGeneration.ValidInputGenerator.NullInputAlerter;
import InputGeneration.ValidInputGenerator.ValidInputGenerator;
import InputGeneration.ValidInputProcessor.ValidInputProcessor;

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

    public static InputProcessor makeAlertingInputProcessor(InputProcessor processor, InputValidator validator, InputAlerter alerter) {
        return new ValidInputProcessor(processor, validator, alerter);
    }

    public static InputProcessor makeValidatingInputGenerator(InputProcessor processor, InputValidator validator) {
        InputAlerter alerter = new NullInputAlerter();
        return makeAlertingInputProcessor(processor, validator, alerter);
    }


}
