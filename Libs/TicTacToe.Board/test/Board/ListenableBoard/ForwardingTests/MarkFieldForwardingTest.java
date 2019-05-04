package Board.ListenableBoard.ForwardingTests;

import Board.BoardMock;
import Board.ListenableBoard.ListenableBoard;
import Board.Mark;
import Data.Field.Field;
import org.junit.jupiter.api.Test;

public class MarkFieldForwardingTest {

    private BoardMock board = new BoardMock();
    private ListenableBoard sut = new ListenableBoard(board);
    private Field field;
    private Mark mark;

    @Test
    void IfR0C1GetsMarkedWithJohn_ItShouldMarkR0C1WithJohnOnTheBoard() {
        makeBoardExpectsJohnIsMarkingRow0Column1();

        sut.mark(field, mark);

        board.verifyAll();
    }

    @Test
    void IfR0C2GetsMarkedWithHaley_ItShouldMarkR0C2WithHaleyOnTheBoard() {
        makeBoardExpectsHaleyIsMarkingRow1Column2();

        sut.mark(field, mark);

        board.verifyAll();
    }

    private void makeBoardExpectsJohnIsMarkingRow0Column1() {
        field = new Field(0, 1);
        mark = Mark.John;
        board.expectGetsMarkedWith(field, mark);
    }

    private void makeBoardExpectsHaleyIsMarkingRow1Column2() {
        field = new Field(1, 2);
        mark = Mark.Haley;
        board.expectGetsMarkedWith(field, mark);
    }

}
