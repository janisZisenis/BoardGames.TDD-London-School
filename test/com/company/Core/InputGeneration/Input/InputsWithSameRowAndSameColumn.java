package com.company.Core.InputGeneration.Input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputsWithSameRowAndSameColumn {

    private Input sut = new Input(-1, 1);
    private Input input = new Input(-1, 1);

    @Test
    void TheFieldsShouldNotEqualEachOther() {
        boolean actual = sut.equals(input);

        assertTrue(actual);
    }

    @Test
    void IfTwoFieldsHaveSameRowAndSameColumn_TheyShouldHaveTheSameHashCode() {
        int actual = sut.hashCode();

        int expected = input.hashCode();
        assertEquals(expected, actual);
    }
}
