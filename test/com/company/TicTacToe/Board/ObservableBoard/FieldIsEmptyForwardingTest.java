package com.company.TicTacToe.Board.ObservableBoard;

import com.company.TicTacToe.Board.BoardStub;
import com.company.TicTacToe.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldIsEmptyForwardingTest {

    private BoardStub board = new BoardStub();
    private ObservableBoard sut = new ObservableBoard(board);
    private Field[] fields;

    private boolean actual;

    @Test
    void IfFieldIsEmptyOnTheBoard_ItShouldBeEmptyEither() {
        makeFieldIsEmpty();

        actual = sut.isEmpty(fields[0]);

        assertTrue(actual);
    }

    @Test
    void IfFieldIsNotEmptyOnTheBoard_ItShouldBeNotEmptyEither() {
        makeFieldIsNotEmpty();

        actual = sut.isEmpty(fields[0]);

        assertFalse(actual);
    }

    private void makeFieldIsEmpty() {
        fields = new Field[] { new Field(0, 0) };
        board.setEmptyFields(fields);
    }

    private void makeFieldIsNotEmpty() {
        fields = new Field[]{new Field(0, 0)};
    }

}
