package Messaging.Player.PlayerMessengerImp;

import Lib.Data.Field.Field;

public class HumbleMarkedFieldMessageProviderImp implements MarkedFieldMessageProvider {

    public String getMarkedFieldMessage(Field field) {
        int row = field.getRow();
        int col = field.getColumn();

        return "Field [" + row + ", " + col + "] was marked!";
    }

}
