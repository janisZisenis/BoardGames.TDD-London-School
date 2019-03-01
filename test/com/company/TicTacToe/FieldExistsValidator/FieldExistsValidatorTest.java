package com.company.TicTacToe.FieldExistsValidator;

import com.company.Core.InputGeneration.Input;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FieldExistsValidatorTest {

    FieldExistsValidator sut = new FieldExistsValidator();
    Input input;

    @Test
    void IfInputHasRowAndColumnBetween0And2_ItShouldBeValid() {
        input = new Input(0, 2);

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void IfInputHasNegativeRow_ItShouldNotBeValid() {
        input = new Input(-1, 2);

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void IfInputHasRowBiggerThan2_ItShouldNotBeValid() {
        input = new Input(3, 2);

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void IfInputHasNegativeColumn_ItShouldNotBeValid() {
        input = new Input(0, -1);

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void IfInputHasColumnBiggerThan2_ItShouldNotBeValid() {
        input = new Input(2, 3);

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

}
