package Board.ObservableBoard.ForwardingTests;

import Board.BoardStub;
import Board.ObservableBoard.ObservableBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarkedFieldCountForwardingTest {

    private BoardStub board = new BoardStub();
    private ObservableBoard sut = new ObservableBoard(board);

    private int actual;
    private int expected;

    @Test
    void IfBoardHas0MarkedField_ItShouldHave0MarkedFieldsEither() {
        board.setMarkedFieldCount(0);

        actual = sut.getMarkedFieldCount();

        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void IfBoardHas1MarkedField_ItShouldHave1MarkedFieldsEither() {
        board.setMarkedFieldCount(1);

        actual = sut.getMarkedFieldCount();

        expected = 1;
        assertEquals(expected, actual);
    }

}
