package Messaging;

import Messaging.tested.MappingTurnMessenger.Messenger;

import static org.junit.jupiter.api.Assertions.*;

public class MessengerMock implements Messenger {

    private boolean didPublish = false;
    private Object actual = "";
    private String expected = "";

    public void publish(String message) {
        this.didPublish = true;
        this.actual = message;
    }

    public void expectPublishMessage(String expected) {
        this.expected = expected;
    }

    public void verifyAll() {
        assertTrue(didPublish);
        assertEquals(expected, actual);
    }
}
