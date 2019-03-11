package com.company.Core.InputRules.CompositeRule;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRuleStub;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompositeRuleTest {

    private CompositeRule sut = new CompositeRule();
    private Input input = new Input(0 ,1);

    @Test
    void FreshInstance_InputShouldBeValid() {
        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void AddedInvalidator_InputShouldBeInvalid() {
        makeInvalidatingRuleAdded();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void AddedValidator_InputShouldBeInvalid() {
        makeValidatingRuleAdded();

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void AddedValidatorAfterInvalidator_InputShouldBeFalse() {
        makeInvalidatingRuleAdded();
        makeValidatingRuleAdded();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void AddedInvalidatorAfterValidator_InputShouldBeFalse() {
        makeValidatingRuleAdded();
        makeInvalidatingRuleAdded();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void AddedInvalidatorInBetweenTwoValidators_InputShouldBeFalse() {
        makeValidatingRuleAdded();
        makeInvalidatingRuleAdded();
        makeValidatingRuleAdded();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void AddedInvalidatorAfterTwoValidators_InputShouldBeFalse() {
        makeValidatingRuleAdded();
        makeValidatingRuleAdded();
        makeInvalidatingRuleAdded();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }


    private void makeValidatingRuleAdded() {
        InputRuleStub rule = new InputRuleStub();
        Input[] valid = { input };
        rule.setValidInputs(valid);
        sut.add(rule);
    }

    private void makeInvalidatingRuleAdded() {
        InputRuleStub rule = new InputRuleStub();
        Input[] valid = {};
        rule.setValidInputs(valid);
        sut.add(rule);
    }

}
