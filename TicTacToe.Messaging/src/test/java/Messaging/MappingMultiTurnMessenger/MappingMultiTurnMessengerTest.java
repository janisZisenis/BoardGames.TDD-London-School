package Messaging.MappingMultiTurnMessenger;

import Mapping.ObjectToStringMapperStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MappingMultiTurnMessengerTest {

    private ObjectToStringMapperStub mapper = new ObjectToStringMapperStub();
    private MessengerSpy messenger = new MessengerSpy();
    private MappingMultiTurnMessenger sut = new MappingMultiTurnMessenger(mapper, messenger);

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
