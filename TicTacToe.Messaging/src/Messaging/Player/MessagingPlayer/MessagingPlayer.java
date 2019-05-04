package Messaging.Player.MessagingPlayer;

import Data.Field.Field;
import Lib.Players.PlayerContext;
import Lib.Players.PlayerImp;

public class MessagingPlayer extends PlayerImp {

    private final PlayerMessenger messenger;

    public MessagingPlayer(PlayerContext context, PlayerMessenger messenger) {
        super(context);
        this.messenger = messenger;
    }

    protected void mark(Field f) {
        super.mark(f);
        messenger.publishMarkedField(f);
    }

}
