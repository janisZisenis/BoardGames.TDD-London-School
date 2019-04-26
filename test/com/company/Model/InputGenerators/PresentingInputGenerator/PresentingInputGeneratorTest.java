package com.company.Model.InputGenerators.PresentingInputGenerator;

import com.company.Data.Input.Input;
import com.company.Model.Players.CountingGeneratorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PresentingInputGeneratorTest {

    CountingGeneratorStub generator = new CountingGeneratorStub();
    Input[] inputs = { new Input(1, 2), new Input(0, 0) };

    @Test
    void IfInputIsGenerated_ShouldGenerateTheSameInput() {
        InputPresenterDummy presenter = new InputPresenterDummy();
        PresentingInputGenerator sut = new PresentingInputGenerator(generator, presenter);
        generator.setGeneratedInputs(inputs);

        Input actual = sut.generate();

        Input expected = inputs[0];
        assertEquals(expected, actual);
    }

    @Test
    void IfInputIsGenerated_ShouldPresentTheInput() {
        InputPresenterSpy presenter = new InputPresenterSpy();
        PresentingInputGenerator sut = new PresentingInputGenerator(generator, presenter);
        generator.setGeneratedInputs(inputs);

        sut.generate();

        Input actual = presenter.getShownInput();
        Input expected = inputs[0];
        assertEquals(expected, actual);
    }
}
