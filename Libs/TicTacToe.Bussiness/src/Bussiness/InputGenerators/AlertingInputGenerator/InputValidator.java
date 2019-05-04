package Bussiness.InputGenerators.AlertingInputGenerator;

import Bussiness.Input.Input;

public interface InputValidator {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
