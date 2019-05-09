package Messaging.MappingMultiTurnMessenger;

import Mapping.ObjectToStringMapperStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MappingMultiPlayerMessengerTest {

    private ObjectToStringMapperStub mapper = new ObjectToStringMapperStub();
    private MessengerSpy messenger = new MessengerSpy();
    private MappingMultiPlayerMessenger sut = new MappingMultiPlayerMessenger(mapper, messenger);

    @Test
    void IfMapperMapsToMessage_ShouldPublishMessage() {
        Object o = new Object();
        mapper.setStringForObject("Message", o);

        sut.publishPlayer(o);

        assertPublishedEquals("Message");
    }

    private void assertPublishedEquals(String expected) {
        String actual = messenger.getPublished();
        assertEquals(expected, actual);
    }

}
