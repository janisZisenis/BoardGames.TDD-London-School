package Domain.Board.ListenableBoard.ForwardingTests;

import Domain.Data.Field.Field;
import Domain.Board.BoardStub;
import Domain.Board.ListenableBoard.ListenableBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
