package View;

import Game.GameMessengerImp.Messenger;

public class ConsoleMessenger implements Messenger {

    public void publish(String message) {
        System.out.println(message);
    }

}
