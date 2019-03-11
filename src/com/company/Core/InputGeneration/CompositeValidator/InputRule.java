package com.company.Core.InputGeneration.CompositeValidator;

import com.company.Core.InputGeneration.Input.Input;

public interface InputRule {
    boolean validates(Input input);
}
