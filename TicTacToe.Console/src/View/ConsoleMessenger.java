package View;

import Lib.GameMessengerImp.Messenger;

public class ConsoleMessenger implements Messenger {

    public void publish(String message) {
        System.out.println(message);
    }

}
