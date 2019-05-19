package Domain.Board.BoardDecorators.ObservableBoard;

import Domain.Board.Board;
import Domain.Board.BoardDummy;
import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Utilities.Observer.Observer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObservingOrderShuntTest extends BoardDummy implements Observer {

    private Board board = this;
    private ObservableBoard sut = new ObservableBoard(board);
    
    private String logString = "";

    @Test
    void IfOneObserverIsAttached_ItShouldBeUpdatedAfterMarkingAField() {
        makeShuntIsAttachedAsObserver();

        sut.mark(new Field(0, 0), Mark.John);

        assertLogStringEquals("mark update ");
    }

    @Test
    void IfOneObserverIsAttached_ItShouldBeUpdatedAfterClearing() {
        makeShuntIsAttachedAsObserver();

        sut.clear();

        assertLogStringEquals("clear update ");
    }

    private void assertLogStringEquals(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    private void makeShuntIsAttachedAsObserver() {
        sut.attach(this);
    }

    public void update() {
        logString += "update ";
    }

    public void mark(Field f, Mark m) {
        logString += "mark ";
    }

    public void clear() {
        logString += "clear ";
    }

}
