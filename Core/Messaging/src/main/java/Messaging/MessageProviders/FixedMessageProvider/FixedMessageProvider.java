package Messaging.MessageProviders.FixedMessageProvider;

import Messaging.GameLoopMessengerImp.MessageProvider;

public class FixedMessageProvider implements MessageProvider {

    private final String message;

    public FixedMessageProvider(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
