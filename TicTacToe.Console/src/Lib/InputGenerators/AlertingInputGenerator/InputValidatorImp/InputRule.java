package Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp;

import Lib.Data.Input.Input;

public interface InputRule {
    boolean isValid(Input input);
}
