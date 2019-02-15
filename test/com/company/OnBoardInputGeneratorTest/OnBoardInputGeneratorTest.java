package com.company.OnBoardInputGeneratorTest;

import com.company.UserInput;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OnBoardInputGeneratorTest {

    InputGeneratorStub generator = new InputGeneratorStub();
    IsOnFieldValidatorStub validator = new IsOnFieldValidatorStub();
    OnBoardInputGenerator sut = new OnBoardInputGenerator(generator, validator);
    UserInput[] inputs;


    @Test
    void IfGeneratedUserInputIsOnField_ShouldBeTheFirstUserInput() {
        makeFirstUserInputIsOnField();

        UserInput actual = sut.generateInput();

        UserInput expected = inputs[0];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstGeneratedUserInputIsNotOnField_ShouldBeTheSecondUserInput() {
        makeFirstInputIsNotOnField();

        UserInput actual = sut.generateInput();

        UserInput expected = inputs[1];
        assertEquals(expected, actual);
    }

    @Test
    void IfSecondGeneratedUserInputIsNotOnField_ShouldBeTheThirdUserInput() {
        makeSecondInputIsNotOnField();

        UserInput actual = sut.generateInput();

        UserInput expected = inputs[2];
        assertEquals(expected, actual);
    }

    private void makeFirstUserInputIsOnField() {
        validator.setTimesUserInputIsNotOnField(0);

        inputs = new UserInput[] { new UserInput(0, 1) };
        generator.setUserInputs(inputs);
    }

    private void makeFirstInputIsNotOnField() {
        validator.setTimesUserInputIsNotOnField(1);

        inputs = new UserInput[]{ new UserInput(0, 1),
                                  new UserInput(1, 2 ) };
        generator.setUserInputs(inputs);
    }

    private void makeSecondInputIsNotOnField() {
        validator.setTimesUserInputIsNotOnField(2);

        inputs = new UserInput[]{ new UserInput(0, 1),
                                  new UserInput(1, 2),
                                  new UserInput(2, 3) };
        generator.setUserInputs(inputs);
    }


}