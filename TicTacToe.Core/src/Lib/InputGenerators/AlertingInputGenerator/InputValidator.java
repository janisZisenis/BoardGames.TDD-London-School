package Lib.InputGenerators.AlertingInputGenerator;

import Lib.Input.Input;

public interface InputValidator {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
