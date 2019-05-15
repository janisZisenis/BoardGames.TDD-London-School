package Messaging.GameLoopMessengerImp;

import Messaging.MappingPlayerMessenger.Messenger;
import Gaming.MessagingGameLoop.GameLoopMessenger;

public class GameLoopMessengerImp implements GameLoopMessenger {

    private final Messenger messenger;
    private final MessageProvider startProvider;
    private final MessageProvider endProvider;

    public GameLoopMessengerImp(Messenger messenger, MessageProvider startProvider, MessageProvider endProvider) {
        this.messenger = messenger;
        this.startProvider = startProvider;
        this.endProvider = endProvider;
    }

    public void publishStart() {
        String message = startProvider.getMessage();
        messenger.publish(message);
    }

    public void publishEnd() {
        String message = endProvider.getMessage();
        messenger.publish(message);
    }
}
