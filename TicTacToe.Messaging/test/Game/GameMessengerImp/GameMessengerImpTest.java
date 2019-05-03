package Game.GameMessengerImp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameMessengerImpTest {

    private MessengerSpy messenger = new MessengerSpy();
    private GameOverMessageProviderStub provider = new GameOverMessageProviderStub();

    @Test
    void publishingTheBeginningMessage_ShouldPublishTheSalutation() {
        String salutation = "Salutation";
        GameMessengerImp sut = makeGameMessengerImp(salutation);

        sut.publishBeginningMessage();

        assertPublishedMessageEquals("Salutation");
    }

    @Test
    void publishingTheEndingMessage_ShouldPublishTheProvidedGameOverMessage() {
        GameMessengerImp sut = makeGameMessengerImp();
        provider.setGameOverMessage("GameOver");

        sut.publishEndingMessage();

        assertPublishedMessageEquals("GameOver");
    }

    private GameMessengerImp makeGameMessengerImp() {
        String salutation = "";
        return makeGameMessengerImp(salutation);
    }

    private GameMessengerImp makeGameMessengerImp(String salutation) {
        return new GameMessengerImp(messenger, provider, salutation);
    }

    private void assertPublishedMessageEquals(String gameOver) {
        String actual = messenger.getPublishedMessage();
        String expected = gameOver;
        assertEquals(expected, actual);
    }

}
