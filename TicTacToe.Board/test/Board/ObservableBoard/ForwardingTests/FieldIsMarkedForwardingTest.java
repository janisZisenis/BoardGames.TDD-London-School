package Board.ObservableBoard.ForwardingTests;

import Data.Field.Field;
import Board.BoardStub;
import Board.ObservableBoard.ObservableBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldIsMarkedForwardingTest {

    private BoardStub board = new BoardStub();
    private ObservableBoard sut = new ObservableBoard(board);
    private Field[] fields;

    private boolean actual;

    @Test
    void IfFieldIsEmptyOnTheBoard_ItShouldNotBeEmpty() {
        makeFieldIsNotMarked();

        actual = sut.isMarked(fields[0]);

        assertFalse(actual);
    }

    @Test
    void IfFieldIsMarkedOnTheBoard_ItShouldBeMarkedEither() {
        makeFieldIsMarked();

        actual = sut.isMarked(fields[0]);

        assertTrue(actual);
    }

    private void makeFieldIsMarked() {
        fields = new Field[] { new Field(0, 0) };
        board.setMarkedFields(fields);
    }

    private void makeFieldIsNotMarked() {
        fields = new Field[]{new Field(0, 0)};
    }

}
