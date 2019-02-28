package com.company.Core.InputGeneration.CompositeValidator;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputValidatorStub;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompositeValidatorTest {

    @Test
    void FreshInstance_InputShouldBeValid() {
        CompositeValidator sut = new CompositeValidator();
        Input input = new Input(0 ,1);

        boolean actual = sut.validate(input);

        assertTrue(actual);
    }

    @Test
    void AddedInvalidating_InputShouldBeInvalid() {
        CompositeValidator sut = new CompositeValidator();
        Input input = new Input(0, 1);
        InputValidatorStub validator = new InputValidatorStub();
        Input[] valid = {};
        validator.setValidInputs(valid);
        sut.add(validator);

        boolean actual = sut.validate(input);

        assertFalse(actual);
    }

    @Test
    void AddedValidating_InputShouldBeInvalid() {
        CompositeValidator sut = new CompositeValidator();
        Input input = new Input(0, 1);
        InputValidatorStub validator = new InputValidatorStub();
        Input[] valid = { new Input (0, 1) };
        validator.setValidInputs(valid);
        sut.add(validator);

        boolean actual = sut.validate(input);

        assertTrue(actual);
    }

    @Test
    void nextTestGoesHere() {
        //second validator adding!
        assertFalse(true);
    }

}
