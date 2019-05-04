package Messaging.Player.PlayerMessengerImp;

import Domain.Data.Field.Field;

public class HumbleMarkedFieldMessageProviderImp implements MarkedFieldMessageProvider {

    public Object getMarkedFieldMessage(Field field) {
        int row = field.getRow();
        int col = field.getColumn();

        return "Domain.Data.Field [" + row + ", " + col + "] was marked!";
    }

}
