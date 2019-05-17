package FXView;

import Messaging.MappingPlayerMessenger.Messenger;

public class ConsoleMessenger implements Messenger {

    public void publish(String message) {
        System.out.println(message);
    }

}
