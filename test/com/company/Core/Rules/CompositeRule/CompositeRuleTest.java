package com.company.Core.Rules.CompositeRule;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRuleStub;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompositeRuleTest {

    private CompositeRule sut = new CompositeRule();
    private Input input = new Input(0 ,1);

    @Test
    void FreshInstance_InputShouldBeValid() {
        boolean actual = sut.validates(input);

        assertTrue(actual);
    }

    @Test
    void AddedInvalidator_InputShouldBeInvalid() {
        makeInvalidatorAdded();

        boolean actual = sut.validates(input);

        assertFalse(actual);
    }

    @Test
    void AddedValidator_InputShouldBeInvalid() {
        makeValidatorAdded();

        boolean actual = sut.validates(input);

        assertTrue(actual);
    }

    @Test
    void AddedValidatorAfterInvalidator_InputShouldBeFalse() {
        makeInvalidatorAdded();
        makeValidatorAdded();

        boolean actual = sut.validates(input);

        assertFalse(actual);
    }

     @Test
     void AddedInvalidatorAfterValidator_InputShouldBeFalse() {
        makeValidatorAdded();
        makeInvalidatorAdded();

        boolean actual = sut.validates(input);

        assertFalse(actual);
    }

    @Test
    void AddedInvalidatorInBetweenTwoValidators_InputShouldBeFalse() {
        makeValidatorAdded();
        makeInvalidatorAdded();
        makeValidatorAdded();

        boolean actual = sut.validates(input);

        assertFalse(actual);
    }

    @Test
    void AddedInvalidatorAfterTwoValidators_InputShouldBeFalse() {
        makeValidatorAdded();
        makeValidatorAdded();
        makeInvalidatorAdded();

        boolean actual = sut.validates(input);

        assertFalse(actual);
    }


    private void makeValidatorAdded() {
        InputRuleStub validator = new InputRuleStub();
        Input[] valid = { input };
        validator.setValidInputs(valid);
        sut.add(validator);
    }

    private void makeInvalidatorAdded() {
        InputRuleStub validator = new InputRuleStub();
        Input[] valid = {};
        validator.setValidInputs(valid);
        sut.add(validator);
    }

}
