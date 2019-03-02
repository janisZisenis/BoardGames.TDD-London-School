package com.company.Core.InputGeneration.CompositeValidator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputValidatorStub;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompositeValidatorTest {

    private CompositeValidator sut = new CompositeValidator();
    private Input input = new Input(0 ,1);

    @Test
    void FreshInstance_InputShouldBeValid() {
        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void AddedInvalidator_InputShouldBeInvalid() {
        makeInvalidatorAdded();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void AddedValidator_InputShouldBeInvalid() {
        makeValidatorAdded();

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void AddedValidatorAfterInvalidator_InputShouldBeFalse() {
        makeInvalidatorAdded();
        makeValidatorAdded();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

     @Test
     void AddedInvalidatorAfterValidator_InputShouldBeFalse() {
        makeValidatorAdded();
        makeInvalidatorAdded();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void AddedInvalidatorInBetweenTwoValidators_InputShouldBeFalse() {
        makeValidatorAdded();
        makeInvalidatorAdded();
        makeValidatorAdded();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void AddedInvalidatorAfterTwoValidators_InputShouldBeFalse() {
        makeValidatorAdded();
        makeValidatorAdded();
        makeInvalidatorAdded();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }


    private void makeValidatorAdded() {
        InputValidatorStub validator = new InputValidatorStub();
        Input[] valid = { input };
        validator.setValidInputs(valid);
        sut.add(validator);
    }

    private void makeInvalidatorAdded() {
        InputValidatorStub validator = new InputValidatorStub();
        Input[] valid = {};
        validator.setValidInputs(valid);
        sut.add(validator);
    }

}
