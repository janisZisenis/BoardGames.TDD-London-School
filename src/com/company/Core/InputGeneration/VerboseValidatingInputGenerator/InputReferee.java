package com.company.Core.InputGeneration.VerboseValidatingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;

public interface InputReferee {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
