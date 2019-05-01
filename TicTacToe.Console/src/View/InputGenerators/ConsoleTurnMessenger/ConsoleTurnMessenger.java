package View.InputGenerators.ConsoleTurnMessenger;

import Lib.TwoPlayerTurn.MessagingTwoPlayerTurn.TurnMessenger;

import java.util.HashMap;

public class ConsoleTurnMessenger implements TurnMessenger {

    private final HashMap<Object, String> names = new HashMap<Object, String>();
    private final String messageEnding = ", it's your turn!";

    public void register(Object player, String name) {
        names.put(player, name);
    }

    public void publishTurnMessageFor(Object player) {
        String name = names.get(player);
        System.out.println(name + messageEnding);
    }
}
