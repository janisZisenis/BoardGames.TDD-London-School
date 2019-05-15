package Gaming.MultiPlayer;

import Gaming.GameFacade.Player;
import Utilities.CyclicListIterator.CyclicListIterator;

import java.util.LinkedList;
import java.util.List;

public class MultiPlayer implements Player {

    private final List<Player> players = new LinkedList<>();
    private final CyclicListIterator<Player> it;
    private final MultiPlayerMessenger messenger;

    public MultiPlayer(Player first, MultiPlayerMessenger messenger) {
        this.players.add(first);
        this.it = new CyclicListIterator<>(players);
        this.messenger = messenger;
    }

    public void play() {
        Player t = it.getCurrent();

        messenger.publishPlayer(t);
        t.play();

        it.next();
    }

    public void add(Player t) {
        players.add(t);
    }

}
