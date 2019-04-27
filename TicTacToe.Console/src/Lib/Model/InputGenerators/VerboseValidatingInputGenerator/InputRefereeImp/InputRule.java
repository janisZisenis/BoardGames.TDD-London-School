package Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp;

import Lib.Data.Input.Input;

public interface InputRule {
    boolean isValid(Input input);
}
