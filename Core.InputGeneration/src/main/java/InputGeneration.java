import InputGeneration.CompositeInputValidator.CompositeInputValidator;
import InputGeneration.InputGenerator;
import InputGeneration.ValidatingInputGenerator.AlertingInputGenerator.AlertingInputGenerator;
import InputGeneration.ValidatingInputGenerator.AlertingInputGenerator.InputAlerter;
import InputGeneration.ValidatingInputGenerator.InputValidator;
import InputGeneration.ValidatingInputGenerator.ValidatingInputGenerator;

public abstract class InputGeneration {

    public static CompositeInputValidator makeCompositeInputValidator() {
        return new CompositeInputValidator();
    }

    public static InputGenerator makeAlertingInputGenerator(InputGenerator generator, InputValidator validator, InputAlerter alerter) {
        return new AlertingInputGenerator(generator, validator, alerter);
    }

    public static InputGenerator makeValidatingInputGenerator(InputGenerator generator, InputValidator validator) {
        return new ValidatingInputGenerator(generator, validator);
    }

}
