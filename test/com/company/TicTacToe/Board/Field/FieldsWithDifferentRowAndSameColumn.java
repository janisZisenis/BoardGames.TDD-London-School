package com.company.TicTacToe.Board.Field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FieldsWithDifferentRowAndSameColumn {

    private Field sut = new Field(-1, 1);
    private Field field = new Field(1, 1);

    @Test
    void TheyShouldNotEqualEachOther() {
        boolean actual = sut.equals(field);

        assertFalse(actual);
    }

    @Test
    void TheyShouldNotHaveTheSameHashCode() {
        int actual = sut.hashCode();

        int unexpected = field.hashCode();
        assertNotEquals(unexpected, actual);
    }
}
