package com.company.Model.InputGenerators.VerboseValidatingInputGenerator;

import com.company.Data.Input.Input;

public interface InputReferee {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
