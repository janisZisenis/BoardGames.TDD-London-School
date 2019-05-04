package Gaming.InputGenerators.AlertingInputGenerator;

import Gaming.Input.Input;

public interface InputValidator {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
