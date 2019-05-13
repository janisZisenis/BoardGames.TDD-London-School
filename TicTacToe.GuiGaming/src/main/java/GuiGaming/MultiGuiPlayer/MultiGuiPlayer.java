package GuiGaming.MultiGuiPlayer;

import Domain.Data.Field.Field;
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

    public void play(Field field) {
        GuiPlayer current = it.getCurrent();
        current.play(field);
        it.next();
    }

    public void play(Input input) {

    }

    public void add(GuiPlayer player) {
        players.add(player);
    }

}
