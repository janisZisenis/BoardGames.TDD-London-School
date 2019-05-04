package Domain.Board.ObservableBoard;

import Data.Field.Field;
import Domain.Board.Board;
import Domain.Board.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObservingOrderShuntTest implements Observer, Board {

    private Board board = this;
    private ObservableBoard sut = new ObservableBoard(board);
    
    private String logString = "";

    @Test
    void IfOneObserverIsAttached_ItShouldBeUpdatedWhenMarkingAField() {
        makeShuntIsAttachedAsObserver();

        sut.mark(new Field(0, 0), Mark.John);

        String actual = logString;
        String expected = "MarkedUpdated";
        assertEquals(expected, actual);
    }

    private void makeShuntIsAttachedAsObserver() {
        sut.attach(this);
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
