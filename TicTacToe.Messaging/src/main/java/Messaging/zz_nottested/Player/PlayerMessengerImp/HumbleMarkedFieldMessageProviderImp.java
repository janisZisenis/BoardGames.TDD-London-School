package Messaging.zz_nottested.Player.PlayerMessengerImp;

import Domain.Data.Field.Field;
import Messages.MarkedFieldMessage;
import Messaging.MessagingBoardListener.MarkedFieldMessageProvider;

public class HumbleMarkedFieldMessageProviderImp implements MarkedFieldMessageProvider {

    public String getMarkedFieldMessage(Field field) {
        return  MarkedFieldMessage.getMarkedFieldMessage(field);
    }

}
