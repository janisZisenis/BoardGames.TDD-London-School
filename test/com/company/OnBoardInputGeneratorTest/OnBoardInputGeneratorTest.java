package com.company.OnBoardInputGeneratorTest;

import com.company.UserInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OnBoardInputGeneratorTest {

    InputGeneratorStub generator = new InputGeneratorStub();
    IsOnFieldValidatorStub field = new IsOnFieldValidatorStub();
    OnBoardInputGenerator sut = new OnBoardInputGenerator(generator, field);
    UserInput input = new UserInput(0, 1);


    @Test
    void IfGeneratedUserInputIsOnField_ShouldBeTheSameUserInput() {
        makeGeneratedUserInputIsOnField();

        UserInput actual = sut.generateInput();

        UserInput expected = input;
        assertEquals(expected, actual);
    }

    private void makeGeneratedUserInputIsOnField() {
        generator.setUserInput(input);
        field.setUserInputIsOnBoard(true);
    }

}