package GuiGaming.Presentation.BoardPresenter;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

public class BoardViewSpy implements BoardView {

    private Field setField;
    private Mark setMark;
    private boolean didSetField = false;

    private Field cleared;
    private boolean didClear = false;

    public boolean hasSetField() {
        return didSetField;
    }
    public Field getSetField() {
        return setField;
    }
    public Mark getSetMark() {
        return setMark;
    }
    public void setField(Field field, Mark mark) {
        didSetField = true;
        setField = field;
        setMark = mark;
    }

    public boolean hasCleared() {
        return didClear;
    }
    public Field getCleared() {
        return cleared;
    }
    public void clearField(Field field) {
        didClear = true;
        cleared = field;
    }

}
