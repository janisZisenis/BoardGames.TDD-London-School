package Game.GameMessengerImp;

import Game.MessagingGame.GameMessenger;
import Game.GameOverMessageProviderImp.GameOverMessageProvider;

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
