package Messaging.Player.MessagingPlayer;

import Lib.Data.Field.Field;

public interface PlayerMessenger {
    void publishPlayedMove(Field field);
}
