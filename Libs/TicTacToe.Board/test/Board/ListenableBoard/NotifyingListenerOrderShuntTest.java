package Board.ListenableBoard;

import Board.Board;
import Board.Mark;
import Data.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotifyingListenerOrderShuntTest implements BoardListener, Board {

    private Board board = this;
    private ListenableBoard sut = new ListenableBoard(board);
    
    private String logString = "";

    @Test
    void IfListenerIsSet_ItShouldBeUpdatedWhenAfterMarkingTheField() {
        sut.setListener(this);

        sut.mark(new Field(0, 0), Mark.John);

        String actual = logString;
        String expected = "marked updatedField ";
        assertEquals(expected, actual);
    }

    public void udpateField(Field f) {
        logString += "updatedField ";
    }

    public void mark(Field f, Mark m) {
        logString += "marked ";
    }

    public boolean isEmpty(Field f) {
        return false;
    }

    public boolean isMarked(Field f) {
        return false;
    }

    public Mark getMarkAt(Field f) {
        return null;
    }

    public int getMarkedFieldCount() {
        return 0;
    }

}
