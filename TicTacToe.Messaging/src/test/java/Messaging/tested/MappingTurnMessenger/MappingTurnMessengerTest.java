package Messaging.tested.MappingTurnMessenger;

import Mapping.ObjectToStringMapperStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MappingTurnMessengerTest {

    private MessengerSpy messenger = new MessengerSpy();
    private ObjectToStringMapperStub mapper = new ObjectToStringMapperStub();
    private MappingTurnMessenger sut = new MappingTurnMessenger(messenger, mapper);

    @Test
    void IfMapperMapsToMessage_ShouldPublishMessage() {
        Object o = new Object();
        mapper.setStringForObject("Message", o);

        sut.publishTurn(o);

        assertPublishedEquals("Message");
    }

    private void assertPublishedEquals(String expected) {
        String actual = messenger.getPublished();
        assertEquals(expected, actual);
    }

}
