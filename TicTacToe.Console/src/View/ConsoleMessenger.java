package View;

import Messaging.Messenger;

public class ConsoleMessenger implements Messenger {

    public void publish(String message) {
        System.out.println(message);
    }

}
