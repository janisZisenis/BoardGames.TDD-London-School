package Core.InputGenerators.AlertingInputGenerator;

import Core.Input.Input;

public interface InputValidator {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
