package Messaging;

import Messaging.Messenger;

public class MessengerSpy implements Messenger {

    private String publishedMessage = "";

    public String getPublishedMessage() {
        return publishedMessage;
    }
    public void publish(String message) {
        this.publishedMessage = message;
    }
}
