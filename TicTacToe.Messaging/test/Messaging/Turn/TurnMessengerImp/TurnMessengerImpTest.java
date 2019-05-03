package Messaging.Turn.TurnMessengerImp;

import Messaging.MessengerMock;
import Messaging.Turn.MessagingTurn.TurnMessenger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TurnMessengerImpTest {

    private MessengerMock messenger = new MessengerMock();
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
        messenger.expectPublishMessage("Object");

        sut.publishTurnMessageFor(o);

        messenger.verifyAll();
    }

}
