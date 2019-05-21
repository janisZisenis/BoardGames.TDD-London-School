package Messaging.MessagingBoardListener;

import Domain.Data.Field.Field;
import Messaging.GameLoopMessengerImp.MessageProviderStub;
import Messaging.MessengerMock;
import org.junit.jupiter.api.Test;

public class MessagingBoardListenerTest {

    private MessengerMock messenger = new MessengerMock();
    private MessageProviderStub provider = new MessageProviderStub();
    private MarkedFieldMessageProviderStub fieldMessageProvider = new MarkedFieldMessageProviderStub();
    private MessagingBoardListener sut = new MessagingBoardListener(messenger, fieldMessageProvider, provider);


    @Test
    void IfFieldGetsUpdated_ShouldPublishTheProvidedFieldMessage() {
        Field field = new Field(0, 0);
        fieldMessageProvider.setMessageForField("Message", field);
        messenger.expectPublishesString("Message");

        sut.onFieldUpdated(field);

        messenger.verifyAll();
    }

    @Test
    void IfGetsCleared_ShouldPublishTheProvidedClearMessage() {
        provider.setMessage("Clear");
        messenger.expectPublishesString("Clear");

        sut.onCleared();

        messenger.verifyAll();
    }

}
