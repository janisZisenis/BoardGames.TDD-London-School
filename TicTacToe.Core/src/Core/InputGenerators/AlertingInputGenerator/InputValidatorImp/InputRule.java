package Core.InputGenerators.AlertingInputGenerator.InputValidatorImp;

import Core.Input.Input;

public interface InputRule {
    boolean isValid(Input input);
}
