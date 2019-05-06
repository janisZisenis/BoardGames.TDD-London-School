package InputGeneration.MappingInputAlerter;

import InputGeneration.Input.Input;
import InputGeneration.InputValidatorImp.InputValidator;

import java.util.Arrays;

public class InputValidatorStub implements InputValidator {
    private Input[] valid = {};

    public boolean isValid(Input input) {
        return Arrays.asList(valid).contains(input);
    }

    public void setValidInputs(Input[] valid) {
        this.valid = valid;
    }
}
