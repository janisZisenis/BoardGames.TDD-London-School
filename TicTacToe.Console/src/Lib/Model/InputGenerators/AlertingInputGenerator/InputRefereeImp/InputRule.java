package Lib.Model.InputGenerators.AlertingInputGenerator.InputRefereeImp;

import Lib.Data.Input.Input;

public interface InputRule {
    boolean isValid(Input input);
}
