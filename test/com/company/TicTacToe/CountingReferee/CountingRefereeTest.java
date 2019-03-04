package com.company.TicTacToe.CountingReferee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountingRefereeTest {

    MarkedFieldCountProviderStub provider = new MarkedFieldCountProviderStub();
    CountingReferee sut = new CountingReferee(provider);

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
