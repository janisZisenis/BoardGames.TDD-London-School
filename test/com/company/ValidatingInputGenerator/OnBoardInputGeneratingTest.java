package com.company.ValidatingInputGenerator;

import com.company.UserInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OnBoardInputGeneratingTest {

    InputGeneratorStub generator = new InputGeneratorStub();
    CountingValidatorStub validator = new CountingValidatorStub();
    ValidatingInputGenerator sut = new ValidatingInputGenerator(generator, validator);

    UserInput[] inputs;

    @Test
    void IfFirstUserInputIsOnBoard_ShouldBeTheFirstUserInput() {
        makeFirstUserInputIsOnBoard();

        UserInput actual = sut.generateInput();

        UserInput expected = inputs[0];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstUserInputIsNotOnBoard_ShouldBeTheSecondUserInput() {
        makeFirstInputIsNotOnBoard();

        UserInput actual = sut.generateInput();

        UserInput expected = inputs[1];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstAndSecondUserInputIsNotOnBoard_ShouldBeTheThirdUserInput() {
        makeFirstAndSecondInputIsNotOnBoard();

        UserInput actual = sut.generateInput();

        UserInput expected = inputs[2];
        assertEquals(expected, actual);
    }

    private void makeFirstUserInputIsOnBoard() {
        validator.setTimesUserInputIsInvalid(0);

        inputs = new UserInput[] { new UserInput(0, 1) };
        generator.setUserInputs(inputs);
    }

    private void makeFirstInputIsNotOnBoard() {
        validator.setTimesUserInputIsInvalid(1);

        inputs = new UserInput[]{ new UserInput(0, 1),
                                  new UserInput(1, 2) };
        generator.setUserInputs(inputs);
    }

    private void makeFirstAndSecondInputIsNotOnBoard() {
        validator.setTimesUserInputIsInvalid(2);

        inputs = new UserInput[]{ new UserInput(0, 1),
                                  new UserInput(1, 2),
                                  new UserInput(2, 3) };
        generator.setUserInputs(inputs);
    }


}