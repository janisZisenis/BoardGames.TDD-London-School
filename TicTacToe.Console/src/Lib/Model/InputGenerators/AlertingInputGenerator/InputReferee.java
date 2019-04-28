package Lib.Model.InputGenerators.AlertingInputGenerator;

import Lib.Data.Input.Input;

public interface InputReferee {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
