package Messaging.MessagingBoardListener;

import Domain.Data.Field.Field;
import Messaging.MappingMultiTurnMessenger.MessengerSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessagingBoardListenerTest {

    private MessengerSpy messenger = new MessengerSpy();
    private MarkedFieldMessageProviderStub provider = new MarkedFieldMessageProviderStub();
    private MessagingBoardListener sut = new MessagingBoardListener(messenger, provider);

    private Field field = new Field(0, 0);

    @Test
    void IfFieldGetsUpdated_ShouldPublishTheProvidedMessage() {
        provider.setMessageForField("Message", field);

        sut.onFieldUpdated(field);

        assertHasPublished("Message");
    }

    private void assertHasPublished(String expected) {
        String actual = messenger.getPublished();
        assertEquals(expected, actual);
    }

}
