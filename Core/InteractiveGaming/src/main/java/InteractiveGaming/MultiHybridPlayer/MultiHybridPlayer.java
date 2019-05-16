package InteractiveGaming.MultiHybridPlayer;

import InteractiveGaming.HybridGameImp.HybridPlayer;
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

    public void play() {
        HybridPlayer p = it.getCurrent();
        p.play();
        it.next();
    }

    public void add(HybridPlayer player) {
        players.add(player);
    }

    public void playInput(Input input) {
        HybridPlayer p = it.getCurrent();
        p.playInput(input);
        it.next();
    }

    public boolean isComputer() {
        HybridPlayer p = it.getCurrent();
        return p.isComputer();
    }
}
