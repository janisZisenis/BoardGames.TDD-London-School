package Domain.Board;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

public class BoardSpy extends BoardStub {

    private Field markedField;
    private Mark mark;
    private boolean didClear = false;

    public Field getMarkedField() {
        return markedField;
    }
    public Mark getMark() {
        return mark;
    }
    public void mark(Field f, Mark m) {
        markedField = f;
        mark = m;
    }

    public boolean hasCleared() {
        return didClear;
    }
    public void clear() {
        didClear = true;
    }
}
