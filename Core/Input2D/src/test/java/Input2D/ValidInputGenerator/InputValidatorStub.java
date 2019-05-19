package Input2D.ValidInputGenerator;

import Input2D.Input.Input;

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
