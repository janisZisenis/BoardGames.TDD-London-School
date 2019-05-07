package Messaging.tested.MappingMultiTurnMessenger;

public class MessengerSpy implements Messenger {

    private String published = "";

    public void publish(String message) {
        published = message;
    }
    public String getPublished() {
        return published;
    }
}
