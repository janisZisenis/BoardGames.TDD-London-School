package com.company.Model.InputGenerators.PresentingInputGenerator;

import com.company.Data.Input.Input;

public class InputPresenterSpy extends InputPresenterDummy {
    private Input presented;

    public void present(Input input) {
        presented = input;
    }
    public Input getPresentedInput() {
        return presented;
    }
}
