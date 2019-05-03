package Messaging.Turn.TurnMessengerImp;

import Messaging.MessengerSpy;
import Messaging.Turn.MessagingTurn.TurnMessenger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TurnMessengerImpTest {

    private MessengerSpy messenger = new MessengerSpy();
    private ObjectToStringMapperFake mapper = new ObjectToStringMapperFake();
    private TurnMessengerImp sut = new TurnMessengerImp(messenger, mapper);

    @Test
    void IfNoMappableObjectsAreAvailable_ShouldThrow() {
        Object o = new Object();
        Executable act = () -> { sut.publishTurnMessageFor(o); };

        assertThrows(TurnMessenger.NoTurnMessageForObjectAvailable.class, act);
    }

    @Test
    void IfObjectIsMappable_ShouldPublishTheMappedString() {
        Object o = new Object();
        mapper.register(o, "Object");

        sut.publishTurnMessageFor(o);

        assertPublishedMessageEquals("Object");
    }

    private void assertPublishedMessageEquals(String message) {
        String actual = messenger.getPublishedMessage();
        String expected = message;
        assertEquals(expected, actual);
    }
}
