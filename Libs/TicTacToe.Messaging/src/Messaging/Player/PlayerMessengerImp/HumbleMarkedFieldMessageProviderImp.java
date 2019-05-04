package Messaging.Player.PlayerMessengerImp;

import Data.Field.Field;

public class HumbleMarkedFieldMessageProviderImp implements MarkedFieldMessageProvider {

    public Object getMarkedFieldMessage(Field field) {
        int row = field.getRow();
        int col = field.getColumn();

        return "Data.Field [" + row + ", " + col + "] was marked!";
    }

}
