package com.company.Core.InputGeneration.ValidatingInputGenerator;

import com.company.Core.InputGeneration.CountingValidatorStub;
import com.company.Core.InputGeneration.InputGeneratorStub;
import com.company.Core.InputGeneration.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OnBoardInputGeneratingTest {

    InputGeneratorStub generator = new InputGeneratorStub();
    CountingValidatorStub validator = new CountingValidatorStub();
    ValidatingInputGenerator sut = new ValidatingInputGenerator(generator, validator);

    Input[] inputs;

    @Test
    void IfFirstUserInputIsOnBoard_ShouldBeTheFirstUserInput() {
        makeFirstUserInputIsOnBoard();

        Input actual = sut.generateInput();

        Input expected = inputs[0];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstUserInputIsNotOnBoard_ShouldBeTheSecondUserInput() {
        makeFirstInputIsNotOnBoard();

        Input actual = sut.generateInput();

        Input expected = inputs[1];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstAndSecondUserInputIsNotOnBoard_ShouldBeTheThirdUserInput() {
        makeFirstAndSecondInputIsNotOnBoard();

        Input actual = sut.generateInput();

        Input expected = inputs[2];
        assertEquals(expected, actual);
    }

    private void makeFirstUserInputIsOnBoard() {
        validator.setTimesUserInputIsInvalid(0);

        inputs = new Input[] { new Input(0, 1) };
        generator.setUserInputs(inputs);
    }

    private void makeFirstInputIsNotOnBoard() {
        validator.setTimesUserInputIsInvalid(1);

        inputs = new Input[]{ new Input(0, 1),
                                  new Input(1, 2) };
        generator.setUserInputs(inputs);
    }

    private void makeFirstAndSecondInputIsNotOnBoard() {
        validator.setTimesUserInputIsInvalid(2);

        inputs = new Input[]{ new Input(0, 1),
                                  new Input(1, 2),
                                  new Input(2, 3) };
        generator.setUserInputs(inputs);
    }


}