package com.company.TicTacToe.Board.BoardFake;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Field.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class FakeBoardFromCharInitializingTest {

    private BoardFake sut;
    private char[][] state;

    @Test
    void IfStateIsEmpty_ShouldBeEmpty() {
        state = new char[][]{};

        sut = BoardFake.fromChar(state);

        assertIsEmpty(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyJ_Row0Column0ShouldNotBeEmpty() {
        state = new char[][]{ {'J'} };

        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyDot_Row0Column0ShouldBeEmpty() {
        state = new char[][]{ {'.'} };

        sut = BoardFake.fromChar(state);

        assertIsEmpty(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyDot_GetMarkAtRow0Column0ShouldThrowException() {
        state = new char[][]{ {'.'} };
        sut = BoardFake.fromChar(state);

        Executable act = () -> sut.getMarkAt(new Field(0, 0));

        assertThrows(Board.FieldIsNotMarked.class, act);
    }

    @Test
    void IfStateContainsOnlyJ_Row0Column0ShouldNotBeJohns() {
        state = new char[][]{ {'J'} };

        sut = BoardFake.fromChar(state);

        assertIsJohns(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyH_Row0Column0ShouldNotBeHaleys() {
        state = new char[][]{ {'H'} };

        sut = BoardFake.fromChar(state);

        assertIsHaleys(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyJ_Row0Column1ShouldBeEmpty() {
        state = new char[][]{ {'J'} };

        sut = BoardFake.fromChar(state);

        assertIsEmpty(new Field(0, 1));
    }

    @Test
    void IfStateContainsJJ_Row0Column1ShouldNotBeEmpty() {
        state = new char[][]{ {'J', 'J'} };

        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(0, 1));
    }

    @Test
    void IfStateContainsJH_Row0Column1ShouldNotBeEmpty() {
        state = new char[][]{ {'J', 'H'} };
        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(0, 1));
    }

    @Test
    void IfStateContainsJH_Row0Column1ShouldBeHaleys() {
        state = new char[][]{ {'J', 'H'} };
        sut = BoardFake.fromChar(state);

        assertIsHaleys(new Field(0, 1));
    }

    @Test
    void IfStateContainsJJ_Row0Column1ShouldBeJohns() {
        state = new char[][]{ {'J', 'J'} };
        sut = BoardFake.fromChar(state);

        assertIsJohns(new Field(0, 1));
    }

    @Test
    void IfStateContainsJDot_GetMarkAtRow0Column1ShouldThrowException() {
        state = new char[][]{ {'J', '.'} };
        sut = BoardFake.fromChar(state);

        Executable act = () -> sut.getMarkAt(new Field(0, 1));

        assertThrows(Board.FieldIsNotMarked.class, act);
    }

    @Test
    void IfStateContainsJJ_Row0Column2ShouldBeEmpty() {
        state = new char[][]{ {'J', 'J'} };

        sut = BoardFake.fromChar(state);

        assertIsEmpty(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJJ_Row0Column2ShouldNotBeEmpty() {
        state = new char[][]{ {'J', 'J', 'J'} };

        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJH_Row0Column2ShouldNotBeEmpty() {
        state = new char[][]{ {'J', 'J', 'H'} };

        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJH_Row0Column2ShouldBeHaleys() {
        state = new char[][]{ {'J', 'J', 'H'} };

        sut = BoardFake.fromChar(state);

        assertIsHaleys(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJJ_Row0Column2ShouldBeJohns() {
        state = new char[][]{ {'J', 'J', 'J'} };

        sut = BoardFake.fromChar(state);

        assertIsJohns(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJDot_GetMarkAtRow0Column2ShouldThrowException() {
        state = new char[][]{ {'J', 'J', '.'} };
        sut = BoardFake.fromChar(state);

        Executable act = () -> sut.getMarkAt(new Field(0, 2));

        assertThrows(Board.FieldIsNotMarked.class, act);
    }

    @Test
    void IfStateContainsJJJ_J_Row1Column0ShouldNotBeEmpty() {
        state = new char[][]{ {'J', 'J', 'J'},
                                       {'J'} };

        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(1, 0));
    }

    @Test
    void IfStateContainsJJJ_Dot_Row1Column0ShouldBeEmpty() {
        state = new char[][]{ {'J', 'J', 'J'},
                                       {'.'} };

        sut = BoardFake.fromChar(state);

        assertIsEmpty(new Field(1, 0));
    }

    @Test
    void IfStateContainsJJJ_HH_Row1Column1ShouldNotBeEmpty() {
        state = new char[][]{ {'J', 'J', 'J'},
                                       {'H', 'H'} };

        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(1, 1));
    }

    @Test
    void IfStateContainsJJJ_HDot_Row1Column1ShouldNotBeEmpty() {
        state = new char[][]{ {'J', 'J', 'J'},
                                       {'H', '.'} };

        sut = BoardFake.fromChar(state);

        assertIsEmpty(new Field(1, 1));
    }

    @Test
    void IfStateIsEmpty_ShouldHaveAMarkedFieldCountOf0() {
        state = new char[][]{};

        sut = BoardFake.fromChar(state);

        assertHasMarkedFieldCountOf(0);
    }

    @Test
    void IfStateContainsJ_ShouldHaveAMarkedFieldCountOf1() {
        state = new char[][]{ {'J'} };

        sut = BoardFake.fromChar(state);

        assertHasMarkedFieldCountOf(1);
    }


    @Test
    void IfFieldRow0Column1GetsMarkedWithJohn_ItShouldBeJohns() {
        sut = new BoardFake();
        Field f = new Field(0, 1);
        Mark m = Mark.John;

        sut.mark(f, m);

        assertIsJohns(f);
    }


    private void assertHasMarkedFieldCountOf(int i) {
        int actual = sut.getMarkedFieldCount();
        int expected = i;
        assertEquals(expected, actual);
    }

    private void assertIsNotEmpty(Field field) {
        boolean actual = sut.isEmpty(field);
        assertFalse(actual);
    }

    private void assertIsEmpty(Field field) {
        boolean actual = sut.isEmpty(field);
        assertTrue(actual);
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
