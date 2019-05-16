package Domain.Gaming.TicTacToePlayer;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

public class MarkFieldServiceSpy implements MarkFieldService {

    private Mark placedMark;
    private Field markedField;

    public void mark(Field f, Mark m) {
        this.markedField = f;
        this.placedMark = m;
    }

    public Field getMarkedField() {
        return markedField;
    }

    public Mark getPlacedMark() {
        return placedMark;
    }
}
