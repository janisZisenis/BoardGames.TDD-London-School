package InputGeneration.InputGenerators.AlertingInputGenerator;

import InputGeneration.Input.Input;

public interface InputValidator {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
