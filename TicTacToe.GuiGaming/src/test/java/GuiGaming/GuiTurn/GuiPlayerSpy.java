package GuiGaming.GuiTurn;

import Domain.Data.Field.Field;

public class GuiPlayerSpy implements GuiPlayer {

    private int count = 0;
    private Field markedField;

    public int getMarkedCount() {
        return count;
    }

    public void mark(Field field) {
        markedField = field;
        count++;
    }

    public Field getMarkedField() {
        return markedField;
    }
}
