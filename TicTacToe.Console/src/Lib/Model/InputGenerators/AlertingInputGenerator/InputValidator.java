package Lib.Model.InputGenerators.AlertingInputGenerator;

import Lib.Data.Input.Input;

public interface InputValidator {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
