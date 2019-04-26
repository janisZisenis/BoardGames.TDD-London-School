package com.company.Model.InputGenerators.PresentingInputGenerator;

import com.company.Data.Input.Input;

public class InputPresenterSpy extends InputPresenterDummy {
    private Input shown;

    public void present(Input input) {
        shown = input;
    }
    public Input getShownInput() {
        return shown;
    }
}
