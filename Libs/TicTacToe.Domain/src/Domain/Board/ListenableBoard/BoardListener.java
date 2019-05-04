package Domain.Board.ListenableBoard;

import Domain.Data.Field.Field;

public interface BoardListener {
    void updateField(Field f);
}
