package Lib.GameMessengerImp;

public class MessengerSpy implements Messenger {

    private String publishedMessage = "";

    public String getPublishedMessage() {
        return publishedMessage;
    }
    public void publish(String message) {
        this.publishedMessage = message;
    }
}
