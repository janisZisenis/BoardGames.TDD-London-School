package GuiGaming.MultiGuiPlayer;

import InputGeneration.Input.Input;
import Utilities.CyclicListIterator.CyclicListIterator;

import java.util.LinkedList;
import java.util.List;

public class MultiGuiPlayer implements GuiPlayer {

    private final List<GuiPlayer> players = new LinkedList<>();
    private final CyclicListIterator<GuiPlayer> it;

    public MultiGuiPlayer(GuiPlayer first) {
        players.add(first);
        this.it = new CyclicListIterator<>(players);
    }

    public void play(Input input) {
        GuiPlayer current = it.getCurrent();
        current.play(input);
        it.next();
    }

    public void add(GuiPlayer player) {
        players.add(player);
    }

}
