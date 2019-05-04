package Board.ObservableBoard.ForwardingTests;

import Board.BoardMock;
import Board.Mark;
import Board.ObservableBoard.ObservableBoard;
import Data.Field.Field;
import org.junit.jupiter.api.Test;

public class MarkFieldForwardingTest {

    private BoardMock board = new BoardMock();
    private ObservableBoard sut = new ObservableBoard(board);
    private Field field;
    private Mark mark;

    @Test
    void IfARow0Column1GetsMarkedWithJohn_ItShouldMarkTheRow0Column1WithJohnOnTheBoard() {
        makeBoardExpectsJohnIsMarkingRow0Column1();

        sut.mark(field, mark);

        board.verifyAll();
    }

    @Test
    void IfARow0Column2GetsMarkedWithHaley_ItShouldMarkTheRow0Column2WithHaleyOnTheBoard() {
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
