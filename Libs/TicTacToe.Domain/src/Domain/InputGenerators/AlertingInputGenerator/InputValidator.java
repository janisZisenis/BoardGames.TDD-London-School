package Domain.InputGenerators.AlertingInputGenerator;

import Domain.Input.Input;

public interface InputValidator {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
