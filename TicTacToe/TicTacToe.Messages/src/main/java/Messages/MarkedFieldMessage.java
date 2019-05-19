package Messages;

import Domain.Data.Field.Field;

public abstract class MarkedFieldMessage {

    public static String getMarkedFieldMessage(Field field) {
        int row = field.getRow();
        int col = field.getColumn();

        return "Field [" + row + ", " + col + "] was marked!";
    }
}
