package Lib.Model.InputGenerators.VerboseValidatingInputGenerator;

import Lib.Data.Input.Input;

public interface InputReferee {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
