package InteractiveGaming.XMultiHybridPlayer;

import Gaming.RestartTransaction.ResetPlayerService;
import Input2D.Input.Input;
import Utilities.CyclicListIterator.CyclicListIterator;

import java.util.LinkedList;
import java.util.List;

public class XMultiHybridPlayer implements XHybridPlayer, ResetPlayerService {

    private final List<XHybridPlayer> players = new LinkedList<>();
    private CyclicListIterator<XHybridPlayer> it;

    public XMultiHybridPlayer(XHybridPlayer first) {
        players.add(first);
        initIterator();
    }

    private void initIterator() {
        it = new CyclicListIterator<>(players);
    }

    public void play() {
        XHybridPlayer p = it.getCurrent();
        p.play();
        it.next();
    }

    public void add(XHybridPlayer player) {
        players.add(player);
    }

    public void playInput(Input input) {
        XHybridPlayer p = it.getCurrent();
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
