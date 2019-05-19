package Domain.Board.BoardDecorators.ListenableBoard;

import Domain.Board.Board;
import Domain.Board.BoardDummy;
import Domain.Data.Field.Field;
import Domain.Data.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotifyingListenerOrderShuntTest extends BoardDummy implements BoardListener {

    private Board board = this;
    private ListenableBoard sut = new ListenableBoard(board);
    
    private String logString = "";

    @Test
    void IfListenerIsSet_ItShouldBeUpdatedWhenAfterMarkingTheField() {
        sut.addListener(this);

        sut.mark(new Field(0, 0), Mark.John);

        assertLogStringEquals("mark onFieldUpdated ");
    }

    @Test
    void IfListenerIsSet_ItShouldBeUpdatedWhenAfterClearing() {
        sut.addListener(this);

        sut.clear();

        assertLogStringEquals("clear onCleared ");
    }

    private void assertLogStringEquals(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public void onFieldUpdated(Field f) {
        logString += "onFieldUpdated ";
    }

    public void mark(Field f, Mark m) {
        logString += "mark ";
    }

    public void onCleared() {
        logString += "onCleared ";
    }

    public void clear() {
        logString += "clear ";
    }


}
