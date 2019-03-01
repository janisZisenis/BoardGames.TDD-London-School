package com.company.TicTacToe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldHashingTest {

    @Test
    void IfTwoFieldsHaveSameRowAndColumn_TheyShouldHaveTheSameHashCode() {
        Field first = new Field(-1, 1);
        Field second = new Field(-1, 1);

        int actual = first.hashCode();

        int expected = second.hashCode();
        assertEquals(expected, actual);
    }

    @Test
    void IfTwoFieldsHaveADifferentRow_TheyShouldNotHaveTheSameHashCode() {
        Field first = new Field(-1, 1);
        Field second = new Field(1, 1);

        int actual = first.hashCode();

        int unexpected = second.hashCode();
        assertNotEquals(unexpected, actual);
    }

    @Test
    void IfTwoFieldsHaveAColumnRow_TheyShouldNotHaveTheSameHashCode() {
        Field first = new Field(-1, 1);
        Field second = new Field(1, -1);

        int actual = first.hashCode();

        int unexpected = second.hashCode();
        assertNotEquals(unexpected, actual);
    }

    
}
