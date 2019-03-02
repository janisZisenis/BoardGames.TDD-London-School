package com.company.Core.InputGeneration.Input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DifferentInputsWithTheSameSumOfRowAndColumn {

    private Input sut = new Input(1, -1);
    private Input input = new Input(-1, 1);

    @Test
    void TheShouldNotHaveTheSameHashCode() {
        int actual = sut.hashCode();

        int unexpected = input.hashCode();
        assertNotEquals(unexpected, actual);
    }

}
