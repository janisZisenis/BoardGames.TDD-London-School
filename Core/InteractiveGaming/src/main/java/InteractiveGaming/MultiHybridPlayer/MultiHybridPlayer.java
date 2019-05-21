package InteractiveGaming.MultiHybridPlayer;

import Gaming.RestartTransaction.ResetPlayerService;
import Input2D.Input.Input;
import InteractiveGaming.HybridGameImp.HybridPlayer;
import Utilities.CyclicListIterator.CyclicListIterator;

import java.util.LinkedList;
import java.util.List;

public class MultiHybridPlayer implements HybridPlayer, ResetPlayerService {

    private final List<HybridPlayer> players = new LinkedList<>();
    private CyclicListIterator<HybridPlayer> it;

    public MultiHybridPlayer(HybridPlayer first) {
        players.add(first);
        initIterator();
    }

    private void initIterator() {
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

    public void reset() {
        initIterator();
    }

    public boolean isInputTurn() {
        return it.getCurrent().isInputTurn();
    }
}
