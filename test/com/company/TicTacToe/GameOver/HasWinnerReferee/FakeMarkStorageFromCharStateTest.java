package com.company.TicTacToe.GameOver.HasWinnerReferee;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Field.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class FakeMarkStorageFromCharStateTest {

    private MarkedFieldProviderFake sut;
    private char[][] state;

    @Test
    void IfStateContainsJH_Row0Column1ShouldBeHaleys() {
        state = new char[][]{ {'J', 'H'} };
        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsHaleys(new Field(0, 1));
    }


    @Test
    void IfStateContainsOnlyDot_GetMarkAtRow0Column0ShouldThrowException() {
        state = new char[][]{ {'.'} };
        sut = MarkedFieldProviderFake.fromChar(state);

        Executable act = () -> sut.getMarkAt(new Field(0, 0));

        assertThrows(Board.FieldIsNotMarked.class, act);
    }

    @Test
    void IfStateContainsOnlyJ_Row0Column0ShouldNotBeJohns() {
        state = new char[][]{ {'J'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsJohns(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyH_Row0Column0ShouldNotBeHaleys() {
        state = new char[][]{ {'H'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsHaleys(new Field(0, 0));
    }

    @Test
    void IfStateContainsJJ_Row0Column1ShouldBeJohns() {
        state = new char[][]{ {'J', 'J'} };
        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsJohns(new Field(0, 1));
    }

    @Test
    void IfStateContainsJDot_GetMarkAtRow0Column1ShouldThrowException() {
        state = new char[][]{ {'J', '.'} };
        sut = MarkedFieldProviderFake.fromChar(state);

        Executable act = () -> sut.getMarkAt(new Field(0, 1));

        assertThrows(Board.FieldIsNotMarked.class, act);
    }

    @Test
    void IfStateContainsJJH_Row0Column2ShouldBeHaleys() {
        state = new char[][]{ {'J', 'J', 'H'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsHaleys(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJJ_Row0Column2ShouldBeJohns() {
        state = new char[][]{ {'J', 'J', 'J'} };

        sut = MarkedFieldProviderFake.fromChar(state);

        assertIsJohns(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJDot_GetMarkAtRow0Column2ShouldThrowException() {
        state = new char[][]{ {'J', 'J', '.'} };
        sut = MarkedFieldProviderFake.fromChar(state);

        Executable act = () -> sut.getMarkAt(new Field(0, 2));

        assertThrows(Board.FieldIsNotMarked.class, act);
    }

    private void assertIsHaleys(Field field) {
        Mark actual = sut.getMarkAt(field);
        Mark expected = Mark.Haley;
        assertEquals(expected, actual);
    }

    private void assertIsJohns(Field field) {
        Mark actual = sut.getMarkAt(field);
        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }
}
