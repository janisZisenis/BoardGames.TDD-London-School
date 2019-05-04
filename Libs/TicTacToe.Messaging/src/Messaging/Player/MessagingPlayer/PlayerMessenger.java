package Messaging.Player.MessagingPlayer;

import Domain.Data.Field.Field;

public interface PlayerMessenger {
    void publishMarkedField(Field f);
}
