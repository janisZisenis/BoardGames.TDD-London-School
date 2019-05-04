package Domain.Players;

import Data.Field.Field;
import Domain.Board.Mark;
import Domain.Players.MarkFieldService;

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
