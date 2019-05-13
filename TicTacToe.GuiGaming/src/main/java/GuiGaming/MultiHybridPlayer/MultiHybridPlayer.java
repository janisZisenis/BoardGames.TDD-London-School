package GuiGaming.MultiHybridPlayer;

import InputGeneration.Input.Input;
import Utilities.CyclicListIterator.CyclicListIterator;

import java.util.LinkedList;
import java.util.List;

public class MultiHybridPlayer implements HybridPlayer {

    private final List<HybridPlayer> players = new LinkedList<>();
    private final CyclicListIterator<HybridPlayer> it;

    public MultiHybridPlayer(HybridPlayer first) {
        players.add(first);
        it = new CyclicListIterator<>(players);
    }

//    public boolean needsInput() {
//        HybridPlayer p = it.getCurrent();
//        return p.needsInput();
//    }

    public void play() {
        HybridPlayer p = it.getCurrent();
        p.play();
        it.next();
    }

    public void add(HybridPlayer player) {
        players.add(player);
    }

    public void play(Input input) {
        HybridPlayer p = it.getCurrent();
        p.play(input);
        it.next();
    }

    public boolean needsInput() {
        HybridPlayer p = it.getCurrent();
        return p.needsInput();
    }
}
