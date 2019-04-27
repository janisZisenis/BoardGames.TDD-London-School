package Lib.Model.InputGenerators.VerboseValidatingInputGenerator;

import Lib.Data.Input.Input;
import Lib.Model.Players.InputGenerator;

public class VerboseValidatingInputGenerator implements InputGenerator {

    private final InputGenerator generator;
    private InputReferee referee;

    public VerboseValidatingInputGenerator(InputGenerator generator, InputReferee referee) {
        this.generator = generator;
        this.referee = referee;
    }

    public Input generate() {
        Input input = getInput();

        while(isNotValid(input)) {
            alertInvalid(input);
            input = getInput();
        }

        return input;
    }

    private void alertInvalid(Input input) {
        referee.alertIsInvalid(input);
    }

    private Input getInput() {
        return generator.generate();
    }

    private boolean isNotValid(Input input) {
        return !referee.isValid(input);
    }
}
