package Board.ListenableBoard.ForwardingTests;

import Board.BoardStub;
import Board.ListenableBoard.ListenableBoard;
import Data.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldIsMarkedForwardingTest {

    private BoardStub board = new BoardStub();
    private ListenableBoard sut = new ListenableBoard(board);

    private Field field = new Field(0, 0);
    private boolean actual;

    @Test
    void IfFieldIsMarkedOnTheBoard_ItShouldBeMarkedEither() {
        makeFieldIsMarked();

        actual = sut.isMarked(field);

        assertTrue(actual);
    }

    @Test
    void IfFieldIsNotMarkedOnTheBoard_ItShouldBeNotMarkedEither() {
        actual = sut.isMarked(field);

        assertFalse(actual);
    }

    private void makeFieldIsMarked() {
        Field[] fields = new Field[] { field };
        board.setMarkedFields(fields);
    }
}
