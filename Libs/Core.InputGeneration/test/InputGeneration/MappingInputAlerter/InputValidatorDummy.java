package InputGeneration.MappingInputAlerter;

import InputGeneration.Input.Input;
import InputGeneration.InputValidatorImp.InputValidator;

public class InputValidatorDummy implements InputValidator {

    public boolean isValid(Input input) {
        return false;
    }

}
