package com.company.TicTacToe.Board.BoardFake;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Field.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class BoardFakeTest {

    private BoardFake sut;

    @Test
    void IfStateIsEmpty_ShouldBeEmpty() {
        char[][] state = new char[][]{};

        sut = BoardFake.fromChar(state);

        assertIsEmpty(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyJ_Row0Column0ShouldNotBeEmpty() {
        char[][] state = new char[][]{ {'J'} };

        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyDot_Row0Column0ShouldBeEmpty() {
        char[][] state = new char[][]{ {'.'} };

        sut = BoardFake.fromChar(state);

        assertIsEmpty(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyDot_GetMarkAtRow0Column0ShouldThrowException() {
        char[][] state = new char[][]{ {'.'} };
        sut = BoardFake.fromChar(state);

        Executable act = () -> sut.getMarkAt(new Field(0, 0));

        assertThrows(Board.FieldIsNotMarked.class, act);
    }

    @Test
    void IfStateContainsOnlyJ_Row0Column0ShouldNotBeJohns() {
        char[][] state = new char[][]{ {'J'} };

        sut = BoardFake.fromChar(state);

        assertIsJohns(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyH_Row0Column0ShouldNotBeHaleys() {
        char[][] state = new char[][]{ {'H'} };

        sut = BoardFake.fromChar(state);

        assertIsHaleys(new Field(0, 0));
    }

    @Test
    void IfStateContainsOnlyJ_Row0Column1ShouldBeEmpty() {
        char[][] state = new char[][]{ {'J'} };

        sut = BoardFake.fromChar(state);

        assertIsEmpty(new Field(0, 1));
    }

    @Test
    void IfStateContainsJJ_Row0Column1ShouldNotBeEmpty() {
        char[][] state = new char[][]{ {'J', 'J'} };

        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(0, 1));
    }

    @Test
    void IfStateContainsJH_Row0Column1ShouldNotBeEmpty() {
        char[][] state = new char[][]{ {'J', 'H'} };
        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(0, 1));
    }

    @Test
    void IfStateContainsJH_Row0Column1ShouldBeHaleys() {
        char[][] state = new char[][]{ {'J', 'H'} };
        sut = BoardFake.fromChar(state);

        assertIsHaleys(new Field(0, 1));
    }

    @Test
    void IfStateContainsJJ_Row0Column1ShouldBeJohns() {
        char[][] state = new char[][]{ {'J', 'J'} };
        sut = BoardFake.fromChar(state);

        assertIsJohns(new Field(0, 1));
    }

    @Test
    void IfStateContainsJDot_GetMarkAtRow0Column1ShouldThrowException() {
        char[][] state = new char[][]{ {'J', '.'} };
        sut = BoardFake.fromChar(state);

        Executable act = () -> sut.getMarkAt(new Field(0, 1));

        assertThrows(Board.FieldIsNotMarked.class, act);
    }

    @Test
    void IfStateContainsJJ_Row0Column2ShouldBeEmpty() {
        char[][] state = new char[][]{ {'J', 'J'} };

        sut = BoardFake.fromChar(state);

        assertIsEmpty(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJJ_Row0Column2ShouldNotBeEmpty() {
        char[][] state = new char[][]{ {'J', 'J', 'J'} };

        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJH_Row0Column2ShouldNotBeEmpty() {
        char[][] state = new char[][]{ {'J', 'J', 'H'} };

        sut = BoardFake.fromChar(state);

        assertIsNotEmpty(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJH_Row0Column2ShouldBeHaleys() {
        char[][] state = new char[][]{ {'J', 'J', 'H'} };

        sut = BoardFake.fromChar(state);

        assertIsHaleys(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJJ_Row0Column2ShouldBeJohns() {
        char[][] state = new char[][]{ {'J', 'J', 'J'} };

        sut = BoardFake.fromChar(state);

        assertIsJohns(new Field(0, 2));
    }

    @Test
    void IfStateContainsJJDot_GetMarkAtRow0Column2ShouldThrowException() {
        char[][] state = new char[][]{ {'J', '.'} };
        sut = BoardFake.fromChar(state);

        Executable act = () -> sut.getMarkAt(new Field(0, 2));

        assertThrows(Board.FieldIsNotMarked.class, act);
    }

//    @Test
//    void IfStateContainsJJ_Row0Column1ShouldBeJohns() {
//        char[][] state = new char[][]{ {'J', 'J'} };
//
//        sut = BoardFake.fromChar(state);
//
//        assertIsJohns(new Field(0, 1));
//    }

//

//    @Test
//    void IfStateContainsOnlyEmptyFields_GetMarkShouldThrowException() {
//        char[][] state = new char[][]{ {'.', '.', '.'},
//                {'.', '.', '.'},
//                {'.', '.', '.'} };
//        sut = BoardFake.fromChar(state);
//
//        Executable act = () -> sut.getMarkAt(new Field(0, 0));
//
//        assertThrows(Board.FieldIsNotMarked.class, act);
//    }
//
//    @Test
//    void IfRow0Column0IsJ_Row0Column0ShouldNotBeEmpty() {
//        char[][] state = new char[][]{ {'J', '.', '.'},
//                                       {'.', '.', '.'},
//                                       {'.', '.', '.'} };
//        sut = BoardFake.fromChar(state);
//
//        assertIsNotEmpty(new Field(0, 0));
//    }
//
//    @Test
//    void IfRow0Column0IsJ_Row0Column0ShouldBeJohns() {
//        char[][] state = new char[][]{ {'J', '.', '.'},
//                                       {'.', '.', '.'},
//                                       {'.', '.', '.'} };
//        sut = BoardFake.fromChar(state);
//
//        assertIsJohns(new Field(0, 0));
//    }
//
//    @Test
//    void IfRow0Column0IsH_Row0Column0ShouldBeHaley() {
//        char[][] state = new char[][]{ {'H', '.', '.'},
//                                       {'.', '.', '.'},
//                                       {'.', '.', '.'} };
//        sut = BoardFake.fromChar(state);
//
//        assertIsHaleys(new Field(0, 0));
//    }
//
//    @Test
//    void IfRow0Column0IsJ_Row0Column1ShouldBeEmpty() {
//        char[][] state = new char[][]{ {'J', '.', '.'},
//                                       {'.', '.', '.'},
//                                       {'.', '.', '.'} };
//        sut = BoardFake.fromChar(state);
//
//        assertIsEmpty(new Field(0, 1));
//    }

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
