package Lib.Board.ObservableBoard;

import Lib.Board.Board;
import Lib.Data.Field.Field;
import Lib.Data.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObservingOrderShuntTest implements Observer, Board {

    private Board board = this;
    private ObservableBoard sut = new ObservableBoard(board);
    
    private String logString = "";

    @Test
    void IfOneObserverIsAttached_ItShouldBeUpdatedWhenMarkingAField() {
        makeShuntIsAttachedAsObserver();

        sut.mark(new Field(0, 0), Mark.John);

        String actual = getLogString();
        String expected = "MarkedUpdated";
        assertEquals(expected, actual);
    }

    private void makeShuntIsAttachedAsObserver() {
        sut.attach(this);
    }

    private String getLogString() {
        return logString;
    }

    public void update() {
        logString += "Updated";
    }

    public void mark(Field f, Mark m) {
        logString += "Marked";
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
