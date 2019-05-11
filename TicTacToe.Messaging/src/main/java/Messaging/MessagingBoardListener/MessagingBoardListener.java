package Messaging.MessagingBoardListener;

import Domain.Board.BoardDecorators.ListenableBoard.BoardListener;
import Domain.Data.Field.Field;
import Messaging.MappingPlayerMessenger.Messenger;

public class MessagingBoardListener implements BoardListener {

    private final MarkedFieldMessageProvider provider;
    private final Messenger messenger;

    public MessagingBoardListener(Messenger messenger, MarkedFieldMessageProvider provider) {
        this.messenger = messenger;
        this.provider = provider;
    }

    public void onFieldUpdated(Field f) {
        String message = provider.getMarkedFieldMessage(f);
        messenger.publish(message);
    }

}
