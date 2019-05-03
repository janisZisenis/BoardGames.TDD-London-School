package Lib.GameMessengerImp;

import Lib.GameOverMessageProviderImp.GameOverMessageProvider;
import Lib.Games.MessagingGame.GameMessenger;

public class GameMessengerImp implements GameMessenger {

    private final Messenger messenger;
    private final String salutation;
    private final GameOverMessageProvider provider;

    public GameMessengerImp(Messenger messenger, GameOverMessageProvider provider, String salutation) {
        this.messenger = messenger;
        this.provider = provider;
        this.salutation = salutation;
    }

    public void publishBeginningMessage() {
        messenger.publish(salutation);
    }

    public void publishGameOverMessage() {
        String message = provider.getGameOverMessage();
        messenger.publish(message);
    }
}
