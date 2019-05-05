package Messaging.Player.PlayerMessengerImp;

import Domain.Data.Field.Field;
import Messages.MarkedFieldMessage;

public class HumbleMarkedFieldMessageProviderImp implements MarkedFieldMessageProvider {

    public Object getMarkedFieldMessage(Field field) {
        return  MarkedFieldMessage.getMarkedFieldMessage(field);
    }

}
