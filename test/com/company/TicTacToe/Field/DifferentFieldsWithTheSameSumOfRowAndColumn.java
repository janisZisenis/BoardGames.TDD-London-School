package com.company.TicTacToe.Field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DifferentFieldsWithTheSameSumOfRowAndColumn {

    private Field sut = new Field(1, -1);
    private Field field = new Field(-1, 1);

    @Test
    void TheShouldNotHaveTheSameHashCode() {
        field = new Field(-1, 1);

        int actual = sut.hashCode();

        int unexpected = field.hashCode();
        assertNotEquals(unexpected, actual);
    }

}
