package Api;

import Board.Mark;
import Data.Field.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarkFieldServiceMock implements MarkFieldService {
    private boolean wasMarked = false;

    private Mark expectedMark;
    private Field expectedField;

    private Mark markedMark;
    private Field markedField;

    public void expectFieldWasMarkedWith(Mark m, Field f) {
        this.expectedMark = m;
        this.expectedField = f;
    }

    public void verifyAll() {
        assertTrue(wasMarked);
        assertEquals(expectedMark, markedMark);
        assertEquals(expectedField, markedField);
    }

    public void mark(Field f, Mark m) {
        wasMarked = true;
        markedField = f;
        markedMark = m;
    }
}