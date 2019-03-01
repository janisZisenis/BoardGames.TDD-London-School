package com.company.TicTacToe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldEqualityTest {

    Field sut;
    Field field;

    @Test
    void IfTwoFieldsHaveSameRowAndColumn_TheyShouldEqualEachOther() {
        sut = new Field(-1, 1);
        field = new Field(-1, 1);

        boolean actual = sut.equals(field);

        assertTrue(actual);
    }

    @Test
    void IfTwoFieldsHaveADifferentRow_TheyShouldNotEqualEachOther() {
        sut = new Field(-1, 1);
        field = new Field(1, 1);

        boolean actual = sut.equals(field);

        assertFalse(actual);
    }

    @Test
    void IfTwoFieldsHaveADifferentColumn_TheyShouldNotEqualEachOther() {
        sut = new Field(-1, 1);
        field = new Field(1, -1);

        boolean actual = sut.equals(field);

        assertFalse(actual);
    }

}
