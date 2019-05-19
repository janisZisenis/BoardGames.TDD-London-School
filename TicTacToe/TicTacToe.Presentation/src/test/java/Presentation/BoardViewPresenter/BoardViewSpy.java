package Presentation.BoardViewPresenter;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

public class BoardViewSpy implements BoardView {

    private Field setField;
    private Mark setMark;
    private boolean didSetField = false;

    private Field clearedField;
    private boolean didClearField = false;

    private boolean didClearAll = false;

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

    public boolean hasClearedField() {
        return didClearField;
    }
    public Field getClearedField() {
        return clearedField;
    }
    public void clearField(Field field) {
        didClearField = true;
        clearedField = field;
    }

    public boolean hasClearedAll() {
        return didClearAll;
    }
    public void clearAll() {
        didClearAll = true;
    }
}
