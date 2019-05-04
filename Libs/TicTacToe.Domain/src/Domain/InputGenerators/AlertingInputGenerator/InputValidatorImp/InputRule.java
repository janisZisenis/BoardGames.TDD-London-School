package Domain.InputGenerators.AlertingInputGenerator.InputValidatorImp;

import Domain.Input.Input;

public interface InputRule {
    boolean isValid(Input input);
}
