package Api;

import Board.Mark;
import Data.Field.Field;

public class MarkFieldServiceSpy implements MarkFieldService {

    private Mark mark;
    private Field markedField;

    public void mark(Field f, Mark m) {
        this.markedField = f;
        this.mark = m;
    }

    public Field getMarkedField() {
        return markedField;
    }

    public Mark getMark() {
        return mark;
    }
}
