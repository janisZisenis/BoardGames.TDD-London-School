package Messaging.Game.GameMessengerImp;

import Messaging.MessengerMock;
import org.junit.jupiter.api.Test;

public class GameMessengerImpTest {

    private MessengerMock messenger = new MessengerMock();
    private GameOverMessageProviderStub provider = new GameOverMessageProviderStub();

    @Test
    void publishingTheBeginningMessage_ShouldPublishTheSalutation() {
        String salutation = "Salutation";
        GameMessengerImp sut = makeGameMessengerImp(salutation);
        messenger.expectPublishMessage(salutation);

        sut.publishBeginningMessage();

        messenger.verifyAll();
    }

    @Test
    void publishingTheEndingMessage_ShouldPublishTheProvidedGameOverMessage() {
        GameMessengerImp sut = makeGameMessengerImp();
        String gameOverMessage = "GameOver";
        provider.setGameOverMessage(gameOverMessage);
        messenger.expectPublishMessage(gameOverMessage);

        sut.publishEndingMessage();

        messenger.verifyAll();
    }

    private GameMessengerImp makeGameMessengerImp() {
        String salutation = "";
        return makeGameMessengerImp(salutation);
    }

    private GameMessengerImp makeGameMessengerImp(String salutation) {
        return new GameMessengerImp(messenger, provider, salutation);
    }

}
