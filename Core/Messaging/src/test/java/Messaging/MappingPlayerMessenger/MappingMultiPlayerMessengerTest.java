package Messaging.MappingPlayerMessenger;

import Messaging.MessengerMock;
import Utilities.ObjectToStringMapper.Api.ObjectToStringMapperStub;
import org.junit.jupiter.api.Test;

public class MappingMultiPlayerMessengerTest {

    private ObjectToStringMapperStub mapper = new ObjectToStringMapperStub();
    private MessengerMock messenger = new MessengerMock();
    private MappingMultiPlayerMessenger sut = new MappingMultiPlayerMessenger(mapper, messenger);

    @Test
    void IfMapperMapsToMessage_ShouldPublishMessage() {
        Object o = new Object();
        mapper.setStringForObject("Message", o);
        messenger.expectPublishesString("Message");

        sut.publishPlayer(o);

        messenger.verifyAll();
    }

}
