package Lib.CLI.View.InputGenerators;

import Lib.Model.GameLoop.GameImp.TwoPlayerTurn.VerboseTwoPlayerTurn.TurnMessageView;

import java.util.HashMap;

public class ConsoleTurnMessageView implements TurnMessageView {

    private final HashMap<Object, String> names = new HashMap<Object, String>();
    private final String messageEnding = ", it's your turn!";

    public void register(Object player, String name) {
        names.put(player, name);
    }

    public void showTurnMessageFor(Object player) {
        String name = names.get(player);
        System.out.println(name + messageEnding);
    }
}
