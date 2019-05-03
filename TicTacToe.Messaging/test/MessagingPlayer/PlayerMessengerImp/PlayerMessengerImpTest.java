package MessagingPlayer.PlayerMessengerImp;

import Lib.Data.Field.Field;
import Lib.GameMessengerImp.MessengerSpy;
import Player.PlayerMessengerImp.PlayerMessengerImp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerMessengerImpTest {

    private MessengerSpy messenger = new MessengerSpy();
    private MarkedFieldMessageProviderStub provider = new MarkedFieldMessageProviderStub();
    private PlayerMessengerImp sut = new PlayerMessengerImp(messenger, provider);

    private Field field = new Field(0, 1);

    @Test
    void IfMarkedFieldGetsPublished_ShouldPublishTheProvidedMessage() {
        provider.setMessageForField("Message", field);

        sut.publishPlayedMove(field);

        assertPublishedMessageEquals("Message");
    }

    private void assertPublishedMessageEquals(String expected) {
        String actual = messenger.getPublishedMessage();
        assertEquals(expected, actual);
    }

}
