package Messaging.MessagingBoardListener;

import Domain.Data.Field.Field;
import GameLoopMessengerImp.MessageProviderStub;
import MappingPlayerMessenger.MessengerSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessagingBoardListenerTest {

    private MessengerSpy messenger = new MessengerSpy();
    private MessageProviderStub provider = new MessageProviderStub();
    private MarkedFieldMessageProviderStub fieldMessageProvider = new MarkedFieldMessageProviderStub();
    private MessagingBoardListener sut = new MessagingBoardListener(messenger, fieldMessageProvider, provider);


    @Test
    void IfFieldGetsUpdated_ShouldPublishTheProvidedFieldMessage() {
        Field field = new Field(0, 0);
        fieldMessageProvider.setMessageForField("Message", field);

        sut.onFieldUpdated(field);

        assertHasPublished("Message");
    }

    @Test
    void IfGetsCleared_ShouldPublishTheProvidedClearMessage() {
        provider.setMessage("Clear");

        sut.onCleared();

        assertHasPublished("Clear");
    }

    private void assertHasPublished(String expected) {
        String actual = messenger.getPublished();
        assertEquals(expected, actual);
    }

}
