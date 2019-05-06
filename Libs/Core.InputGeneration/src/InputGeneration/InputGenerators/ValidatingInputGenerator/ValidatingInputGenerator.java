package InputGeneration.InputGenerators.ValidatingInputGenerator;

import InputGeneration.Input.Input;
import InputGeneration.InputGenerator;
import InputGeneration.InputValidatorImp.InputValidator;

public class ValidatingInputGenerator implements InputGenerator {

    private final InputGenerator generator;
    private final InputValidator validator;

    public ValidatingInputGenerator(InputGenerator generator, InputValidator validator) {
        this.generator = generator;
        this.validator = validator;
    }

    public Input generate() {
        Input in = getInput();

        while(isInvalid(in))
            in = getInput();

        return in;
    }

    private Input getInput() {
        return generator.generate();
    }

    private boolean isInvalid(Input in) {
        return !validator.isValid(in);
    }

}
