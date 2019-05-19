package GameLoopMessengerImp;

import MappingPlayerMessenger.MessengerSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLoopMessengerImpTest {

    private MessengerSpy messenger = new MessengerSpy();
    private MessageProviderStub startProvider = new MessageProviderStub();
    private MessageProviderStub endProvider = new MessageProviderStub();
    private GameLoopMessengerImp sut = new GameLoopMessengerImp(messenger, startProvider, endProvider);

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
