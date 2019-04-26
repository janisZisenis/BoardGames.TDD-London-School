package com.company.Model.InputGenerators.PresentingInputGenerator;

import com.company.Data.Input.Input;
import com.company.Model.Players.InputGenerator;

public class PresentingInputGenerator implements InputGenerator {


    private final InputGenerator generator;
    private final InputPresenter presenter;

    public PresentingInputGenerator(InputGenerator generator, InputPresenter presenter) {
        this.generator = generator;
        this.presenter = presenter;
    }

    public Input generate() {
        Input input = generator.generate();
        presenter.show(input);
        return input;
    }
}
