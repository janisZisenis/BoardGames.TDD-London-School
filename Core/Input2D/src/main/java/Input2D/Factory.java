package Input2D;

import Input2D.CompositeInputValidator.CompositeInputValidator;
import Input2D.RandomInputGenerator.RandomInputGenerator;
import Input2D.ValidInputGenerator.InputAlerter;
import Input2D.ValidInputGenerator.InputValidator;
import Input2D.ValidInputGenerator.NullInputAlerter;
import Input2D.ValidInputGenerator.ValidInputGenerator;
import Input2D.ValidInputProcessor.ValidInputProcessor;

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

    public static InputProcessor makeValidatingInputProcessor(InputProcessor processor, InputValidator validator) {
        InputAlerter alerter = new NullInputAlerter();
        return makeAlertingInputProcessor(processor, validator, alerter);
    }

    public static InputGenerator makeRandomInputGenerator(int maxRow, int maxColumn) {
        return new RandomInputGenerator(maxRow, maxColumn);
    }


}
