package Messaging.GameLoopMessengerImp;

import Messaging.MessengerMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLoopMessengerImpTest {

    private MessengerMock messenger = new MessengerMock();
    private MessageProviderStub startProvider = new MessageProviderStub();
    private MessageProviderStub endProvider = new MessageProviderStub();
    private GameLoopMessengerImp sut = new GameLoopMessengerImp(messenger, startProvider, endProvider);

    @Test
    void ShouldPublishStartProvidersMessage() {
        startProvider.setMessage("StartMessage");
        messenger.expectPublishesString("StartMessage");

        sut.publishStart();

        messenger.verifyAll();
    }

    @Test
    void ShouldPublishEndProvidersMessage() {
        endProvider.setMessage("EndMessage");
        messenger.expectPublishesString("EndMessage");

        sut.publishEnd();

        messenger.verifyAll();
    }

}
