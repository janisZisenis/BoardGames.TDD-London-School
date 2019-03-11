package com.company.Core.InputGeneration.ValidatingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;

public interface InputRule {
    boolean isValid(Input input);
}
