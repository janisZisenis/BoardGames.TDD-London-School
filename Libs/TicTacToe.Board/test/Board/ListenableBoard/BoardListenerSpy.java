package Board.ListenableBoard;

import Data.Field.Field;

public class BoardListenerSpy implements BoardListener {

    private Field updatedField;

    public Field getUpdatedField() {
        return updatedField;
    }
    public void udpateField(Field f) {
        updatedField = f;
    }
}
