package com.company.TicTacToe.GameOverRule.TieGameRule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TieGameRuleTest {

    private MarkedFieldCountProviderStub provider = new MarkedFieldCountProviderStub();
    private TieGameRule sut = new TieGameRule(provider);

    @Test
    void If0FieldsAreMarked_ShouldHaveMovesLeft() {
        provider.setMarkedFieldCount(0);

        boolean actual = sut.hasMovesLeft();

        assertTrue(actual);
    }

    @Test
    void If9FieldsAreMarked_ShouldNotHaveMovesLeft() {
        provider.setMarkedFieldCount(9);

        boolean actual = sut.hasMovesLeft();

        assertFalse(actual);
    }

    @Test
    void If1FieldIsMarked_ShouldHaveMovesLeft() {
        provider.setMarkedFieldCount(1);

        boolean actual = sut.hasMovesLeft();

        assertTrue(actual);
    }

    @Test
    void If2FieldAreMarked_ShouldHaveMovesLeft() {
        provider.setMarkedFieldCount(2);

        boolean actual = sut.hasMovesLeft();

        assertTrue(actual);
    }

    @Test
    void If8FieldAreMarked_ShouldHaveMovesLeft() {
        provider.setMarkedFieldCount(8);

        boolean actual = sut.hasMovesLeft();

        assertTrue(actual);
    }

}
