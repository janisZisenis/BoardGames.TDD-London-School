package Domain.Board.BoardDecorators.ListenableBoard;

import Domain.Data.Field.Field;

public class BoardListenerSpy implements BoardListener {

    private Field updatedField;

    public Field getUpdatedField() {
        return updatedField;
    }
    public void onFieldUpdated(Field f) {
        updatedField = f;
    }
}
