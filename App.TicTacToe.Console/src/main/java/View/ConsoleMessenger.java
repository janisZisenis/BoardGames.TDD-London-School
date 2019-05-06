package View;

import Messaging.Messenger;

public class ConsoleMessenger implements Messenger {

    public void publish(Object message) {
        System.out.println(message);
    }

}
