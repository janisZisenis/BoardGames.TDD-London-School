package InputGeneration.ValidInputProcessor;

import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;
import InputGeneration.ValidInputGenerator.InputAlerter;
import InputGeneration.ValidInputGenerator.InputValidator;

public class ValidInputProcessor implements InputProcessor {

    private final InputProcessor processor;
    private final InputValidator validator;
    private final InputAlerter alerter;

    public ValidInputProcessor(InputProcessor processor, InputValidator validator, InputAlerter alerter) {
        this.processor = processor;
        this.validator = validator;
        this.alerter = alerter;
    }

    public void process(Input input) {
        if(validator.isValid(input))
            processor.process(input);
        else
            alerter.alert(input);
    }

}
