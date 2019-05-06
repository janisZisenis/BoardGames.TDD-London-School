package Domain.Board;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardMock extends BoardDummy {

    private boolean wasMarked = false;
    private Field expectedField;
    private Mark expectedMark;
    private Mark actualMark;
    private Field actualField;

    public void expectGetsMarkedWith(Field f, Mark m) {
        this.expectedField = f;
        this.expectedMark = m;
    }

    public void mark(Field f, Mark m) {
        this.wasMarked = true;
        this.actualField = f;
        this.actualMark = m;
    }

    public void verifyAll() {
        assertTrue(wasMarked);
        assertEquals(expectedField, actualField);
        assertEquals(expectedMark, actualMark);
    }

}