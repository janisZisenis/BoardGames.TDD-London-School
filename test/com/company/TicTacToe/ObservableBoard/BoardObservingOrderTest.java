package com.company.TicTacToe.ObservableBoard;

import com.company.TicTacToe.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardObservingOrderTest implements Observer, Board {

    Board board = this;
    ObservableBoard sut = new ObservableBoard(board);

    String logString = "";

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

    public void mark(Field f, Mark m) {
        logString += "Marked";
    }

    public void update() {
        logString += "Updated";
    }
}
