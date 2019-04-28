package Lib.Board.ObservableBoard.ForwardingTests;

import Lib.Board.BoardStub;
import Lib.Data.Mark;
import Lib.Data.Field.Field;
import Lib.Board.ObservableBoard.ObservableBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetMarkForwardingTest {

    private BoardStub board = new BoardStub();
    private ObservableBoard sut = new ObservableBoard(board);
    private Field field;

    @Test
    void IfBoardHasHaleyOnRow0Column1_ItShouldGetTheMarkHaleyOnRow0Column1() {
        makeBoardHasHaleyOnRow0Column1();

        Mark actual = sut.getMarkAt(field);

        Mark expected = Mark.Haley;
        assertEquals(expected, actual);
    }

    @Test
    void IfBoardHasJohnOnRow0Column1_ItShouldGetTheMarkJohnOnRow0Column1() {
        makeBoardHasJohnOnRow0Column1();

        Mark actual = sut.getMarkAt(field);

        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }

    @Test
    void IfBoardHasJohnOnRow1Column2_ItShouldGetTheMarkJohnOnRow0Column2() {
        makeBoardHasJohnOnRow1Column2();

        Mark actual = sut.getMarkAt(field);

        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }


    private void makeBoardHasHaleyOnRow0Column1() {
        field = new Field(0, 1);
        board.setMarkOnField(Mark.Haley, field);
    }

    private void makeBoardHasJohnOnRow0Column1() {
        field = new Field(0, 1);
        board.setMarkOnField(Mark.John, field);
    }

    private void makeBoardHasJohnOnRow1Column2() {
        field = new Field(1, 2);
        board.setMarkOnField(Mark.John, field);
    }

}
