package Lib.PlayerMessengerImp;

import Lib.Data.Field.Field;

public class MarkedFieldMessageProviderImp implements MarkedFieldMessageProvider {

    public String getMarkedFieldMessage(Field field) {
        int row = field.getRow();
        int col = field.getColumn();

        return "Field [" + row + ", " + col + "] was marked!";
    }

}
