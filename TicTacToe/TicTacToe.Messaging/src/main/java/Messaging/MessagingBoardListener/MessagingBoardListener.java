package Messaging.MessagingBoardListener;

import Domain.Board.BoardDecorators.ListenableBoard.BoardListener;
import Domain.Data.Field.Field;
import Messaging.GameLoopMessengerImp.MessageProvider;
import Messaging.Messenger;

public class MessagingBoardListener implements BoardListener {

    private final Messenger messenger;
    private final MarkedFieldMessageProvider fieldMessageProvider;
    private final MessageProvider provider;

    public MessagingBoardListener(Messenger messenger, MarkedFieldMessageProvider fieldMessagseProvider, MessageProvider provider) {
        this.messenger = messenger;
        this.fieldMessageProvider = fieldMessagseProvider;
        this.provider = provider;
    }

    public void onFieldUpdated(Field f) {
        String message = fieldMessageProvider.getMarkedFieldMessage(f);
        messenger.publish(message);
    }

    public void onCleared() {
        String message = provider.getMessage();
        messenger.publish(message);
    }

}
