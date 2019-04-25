package com.company.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp;

import com.company.Data.Input.Input;

public interface InputRule {
    boolean isValid(Input input);
}
