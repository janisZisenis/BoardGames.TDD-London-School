package Messaging.GameLoopMessengerImp;

public class MessageProviderStub implements MessageProvider {

    private String message = "";

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
