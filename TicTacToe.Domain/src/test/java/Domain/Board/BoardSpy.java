package Domain.Board;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

public class BoardSpy extends BoardStub {

    private Field markedField;
    private Mark mark;

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

}
