package Messaging;

import static org.junit.jupiter.api.Assertions.*;

public class MessengerMock implements Messenger {

    private boolean didPublish = false;
    private String actualPublished = "";
    private String expectedPublished = "";

    public void expectPublishesString(String expected) {
        expectedPublished = expected;
    }

    public void publish(String message) {
        didPublish = true;
        actualPublished = message;
    }

    public void verifyAll() {
        assertTrue(didPublish);
        assertEquals(expectedPublished, actualPublished);
    }

}
