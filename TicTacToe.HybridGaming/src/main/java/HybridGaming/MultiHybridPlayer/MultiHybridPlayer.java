package HybridGaming.MultiHybridPlayer;

import HybridGaming.HybridGameImp.HybridPlayer;
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

    public void playComputer() {
        HybridPlayer p = it.getCurrent();
        p.playComputer();
        it.next();
    }

    public void add(HybridPlayer player) {
        players.add(player);
    }

    public void playHuman(Input input) {
        HybridPlayer p = it.getCurrent();
        p.playHuman(input);
        it.next();
    }

    public boolean isComputer() {
        HybridPlayer p = it.getCurrent();
        return p.isComputer();
    }
}
