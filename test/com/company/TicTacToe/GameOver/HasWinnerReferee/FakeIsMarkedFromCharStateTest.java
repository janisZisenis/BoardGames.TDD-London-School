package com.company.TicTacToe.GameOver.HasWinnerReferee;

import com.company.TicTacToe.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FakeIsMarkedFromCharStateTest {

    private MarkedFieldProviderFake sut;
    private char[][] state;

    @Test
    void IfStateIsEmpty_Row0Column0ShouldNotBeMarked() {
        state = new char[][]{};

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsNotMarked(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyJ_Row0Column0ShouldBeMarked() {
        state = new char[][]{ {'J'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsMarked(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyDot_Row0Column0ShouldNotBeMarked() {
        state = new char[][]{ {'.'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsNotMarked(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyJ_Row0Column1ShouldNotBeMarked() {
        state = new char[][]{ {'J'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsNotMarked(new Field(0, 1));
    }

    @Test
    void IfStateContainsJJ_Row0Column1ShouldBeMarked() {
        state = new char[][]{ {'J', 'J'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsMarked(new Field(0, 1));
    }

    @Test
    void IfStateContainsJH_Row0Column1ShouldBeMarked() {
        state = new char[][]{ {'J', 'H'} };
        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsMarked(new Field(0, 1));
    }

    @Test
    void IfStateContainsJJ_Row0Column2ShouldNotBeMarked() {
        state = new char[][]{ {'J', 'J'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsNotMarked(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJJ_Row0Column2ShouldBeMarked() {
        state = new char[][]{ {'J', 'J', 'J'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsMarked(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJH_Row0Column2ShouldBeMarked() {
        state = new char[][]{ {'J', 'J', 'H'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsMarked(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJJ_J_Row1Column0ShouldBeMarked() {
        state = new char[][]{ {'J', 'J', 'J'},
                              {'J'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsMarked(new Field(1, 0));
    }

    @Test
    void IfStateContainsJJJ_Dot_Row1Column0ShouldNotBeMarked() {
        state = new char[][]{ {'J', 'J', 'J'},
                              {'.'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsNotMarked(new Field(1, 0));
    }

    @Test
    void IfStateContainsJJJ_HH_Row1Column1ShouldBeMarked() {
        state = new char[][]{ {'J', 'J', 'J'},
                              {'H', 'H'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsMarked(new Field(1, 1));
    }

    @Test
    void IfStateContainsJJJ_HDot_Row1Column1ShouldBeMarked() {
        state = new char[][]{ {'J', 'J', 'J'},
                              {'H', '.'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsNotMarked(new Field(1, 1));
    }

    private void assertIsMarked(Field field) {
        boolean actual = sut.isMarked(field);
        assertTrue(actual);
    }

    private void assertIsNotMarked(Field field) {
        boolean actual = sut.isMarked(field);
        assertFalse(actual);
    }

}
