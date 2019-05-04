package Board.ListenableBoard;

import Data.Field.Field;

public class BoardListenerSpy implements BoardListener {

    private Field updatedField;

    public Field getUpdatedField() {
        return updatedField;
    }
    public void updateField(Field f) {
        updatedField = f;
    }
}
