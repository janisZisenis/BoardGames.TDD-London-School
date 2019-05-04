package Domain.InputGenerators.ValidatingInputGenerator;

import Domain.Input.Input;
import Domain.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;
import Domain.Players.InputGenerator;

public class ValidatingInputGenerator implements InputGenerator {
    private final InputGenerator generator;
    private final InputRule rule;

    public ValidatingInputGenerator(InputGenerator generator, InputRule rule) {
        this.generator = generator;
        this.rule = rule;
    }

    public Input generate() {
        Input in = getInput();

        while(isNotValid(in))
            in = getInput();

        return in;
    }

    private Input getInput() {
        return generator.generate();
    }

    private boolean isNotValid(Input in) {
        return !rule.isValid(in);
    }
}
