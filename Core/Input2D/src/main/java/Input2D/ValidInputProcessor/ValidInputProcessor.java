package Input2D.ValidInputProcessor;

import Input2D.Input.Input;
import Input2D.InputProcessor;
import Input2D.ValidInputGenerator.InputAlerter;
import Input2D.ValidInputGenerator.InputValidator;

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
