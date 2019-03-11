package com.company.Core.InputGeneration.InputValidatingGenerator;

import com.company.Core.InputGeneration.Input.Input;

public interface InputValidator {

    boolean isValid(Input input);
    void alert();

}
