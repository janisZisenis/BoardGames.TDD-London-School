package com.company.OnBoardInputGenerator;

import com.company.UserInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OnBoardInputGeneratingTest {

    InputGeneratorStub generator = new InputGeneratorStub();
    IsOnBoardValidatorStub validator = new IsOnBoardValidatorStub();
    OnBoardInputGenerator sut = new OnBoardInputGenerator(generator, validator);

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
        validator.setTimesUserInputIsNotOnBoard(0);

        inputs = new UserInput[] { new UserInput(0, 1) };
        generator.setUserInputs(inputs);
    }

    private void makeFirstInputIsNotOnBoard() {
        validator.setTimesUserInputIsNotOnBoard(1);

        inputs = new UserInput[]{ new UserInput(0, 1),
                new UserInput(1, 2 ) };
        generator.setUserInputs(inputs);
    }

    private void makeFirstAndSecondInputIsNotOnBoard() {
        validator.setTimesUserInputIsNotOnBoard(2);

        inputs = new UserInput[]{ new UserInput(0, 1),
                                  new UserInput(1, 2),
                                  new UserInput(2, 3) };
        generator.setUserInputs(inputs);
    }


}