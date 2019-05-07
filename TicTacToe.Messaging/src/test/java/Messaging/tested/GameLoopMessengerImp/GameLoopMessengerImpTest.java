package Messaging.tested.GameLoopMessengerImp;

import Messaging.tested.MappingMultiTurnMessenger.MessengerSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLoopMessengerImpTest {

    MessengerSpy messenger = new MessengerSpy();
    MessageProviderStub startProvider = new MessageProviderStub();
    MessageProviderStub endProvider = new MessageProviderStub();
    GameLoopMessengerImp sut = new GameLoopMessengerImp(messenger, startProvider, endProvider);

    @Test
    void ShouldPublishStartProvidersMessage() {
        startProvider.setMessage("StartMessage");

        sut.publishStart();

        assertHasPublished("StartMessage");
    }

    @Test
    void ShouldPublishEndProvidersMessage() {
        endProvider.setMessage("EndMessage");

        sut.publishEnd();

        assertHasPublished("EndMessage");
    }

    private void assertHasPublished(String expected) {
        String actual = messenger.getPublished();
        assertEquals(expected, actual);
    }

}
