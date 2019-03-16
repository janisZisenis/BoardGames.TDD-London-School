package com.company.TicTacToe.GameOverRule.NumberOfMovesRule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberOfMovesRuleTest {

    private MarkedFieldCountProviderStub provider = new MarkedFieldCountProviderStub();
    private NumberOfMovesRule sut = new NumberOfMovesRule(provider);

    @Test
    void If0FieldsAreMarked_ShouldHaveMovesLeft() {
        provider.setMarkedFieldCount(0);

        boolean actual = sut.hasMoveLeft();

        assertTrue(actual);
    }

    @Test
    void If9FieldsAreMarked_ShouldNotHaveMovesLeft() {
        provider.setMarkedFieldCount(9);

        boolean actual = sut.hasMoveLeft();

        assertFalse(actual);
    }

    @Test
    void If1FieldIsMarked_ShouldHaveMovesLeft() {
        provider.setMarkedFieldCount(1);

        boolean actual = sut.hasMoveLeft();

        assertTrue(actual);
    }

    @Test
    void If2FieldAreMarked_ShouldHaveMovesLeft() {
        provider.setMarkedFieldCount(2);

        boolean actual = sut.hasMoveLeft();

        assertTrue(actual);
    }

    @Test
    void If8FieldAreMarked_ShouldHaveMovesLeft() {
        provider.setMarkedFieldCount(8);

        boolean actual = sut.hasMoveLeft();

        assertTrue(actual);
    }

}
