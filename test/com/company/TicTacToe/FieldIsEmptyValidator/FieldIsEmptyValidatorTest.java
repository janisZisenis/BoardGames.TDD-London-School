package com.company.TicTacToe.FieldIsEmptyValidator;

import com.company.Core.InputGeneration.Input;
import com.company.TicTacToe.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldIsEmptyValidatorTest {

    private FieldIsEmptyProviderStub provider = new FieldIsEmptyProviderStub();
    private FieldIsEmptyValidator sut = new FieldIsEmptyValidator(provider);
    private Input input = new Input(0, 1);

    @Test
    void IfInputRefersToAnEmptyField_ItShouldBeValid() {
        makeInputRefersToAnEmptyField();

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void IfInputRefersToAnOccupiedField_ItShouldNotBeValid() {
        makeInputRefersToAnOccupiedField();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    private void makeInputRefersToAnEmptyField() {
        Field[] empty = { new Field(0, 1) };
        provider.setEmptyFields(empty);
    }

    private void makeInputRefersToAnOccupiedField() {
        Field[] empty = {};
        provider.setEmptyFields(empty);
    }

}
