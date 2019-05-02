package Lib.Players.MessagingPlayer;

import Lib.Data.Field.Field;
import Lib.Data.Mark;

public interface PlayerMessenger {
    void publishPlayedMove(Mark m, Field f);
}
