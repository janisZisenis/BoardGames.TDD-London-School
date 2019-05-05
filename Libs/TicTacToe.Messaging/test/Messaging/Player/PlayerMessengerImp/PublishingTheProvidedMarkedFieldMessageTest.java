package Messaging.Player.PlayerMessengerImp;

import Domain.Data.Field.Field;
import Messaging.MessengerMock;
import org.junit.jupiter.api.Test;

public class PublishingTheProvidedMarkedFieldMessageTest {

    private MessengerMock messenger = new MessengerMock();
    private MarkedFieldMessageProviderStub provider = new MarkedFieldMessageProviderStub();
    private PlayerMessengerImp sut = new PlayerMessengerImp(messenger, provider);

    private Field field = new Field(0, 1);

    @Test
    void IfMarkedFieldGetsPublished_ShouldPublishTheProvidedMessage() {
        provider.setMessageForField("Message", field);
        messenger.expectPublishMessage("Message");

        sut.publishMarkedField(field);

        messenger.verifyAll();
    }

}
