package Domain.Board.BoardDecorators.ListenableBoard;

import Domain.Data.Field.Field;

public class BoardListenerSpy implements BoardListener {

    private boolean didUpdateField = false;
    private Field updatedField;

    public boolean wasUpdated() {
        return didUpdateField;
    }
    public Field getUpdatedField() {
        return updatedField;
    }
    public void onFieldUpdated(Field f) {
        didUpdateField = true;
        updatedField = f;
    }

}
