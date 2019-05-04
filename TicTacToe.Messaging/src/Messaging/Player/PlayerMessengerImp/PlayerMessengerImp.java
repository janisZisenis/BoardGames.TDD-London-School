package Messaging.Player.PlayerMessengerImp;

import Messaging.Messenger;
import Lib.Data.Field.Field;
import Messaging.Player.MessagingPlayer.PlayerMessenger;

public class PlayerMessengerImp implements PlayerMessenger {

    private final Messenger messenger;
    private final MarkedFieldMessageProvider provider;

    public PlayerMessengerImp(Messenger messenger, MarkedFieldMessageProvider provider) {
        this.messenger = messenger;
        this.provider = provider;
    }

    public void publishMarkedField(Field f) {
        Object message = provider.getMarkedFieldMessage(f);
        messenger.publish(message);
    }

}
