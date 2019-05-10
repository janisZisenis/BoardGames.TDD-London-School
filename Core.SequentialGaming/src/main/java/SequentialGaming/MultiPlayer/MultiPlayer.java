package SequentialGaming.MultiPlayer;

import SequentialGaming.GameFacade.Player;

import java.util.LinkedList;
import java.util.List;

public class MultiPlayer implements Player {

    private final LinkedList<Player> players = new LinkedList<>();
    private final CyclicPlayerIterator it = new CyclicPlayerIterator(players);
    private final MultiPlayerMessenger messenger;

    public MultiPlayer(Player first, MultiPlayerMessenger messenger) {
        this.players.add(first);
        this.messenger = messenger;
    }

    public void play() {
        Player t = it.current();

        messenger.publishPlayer(t);
        t.play();

        it.next();
    }

    public void add(Player t) {
        players.add(t);
    }

    private class CyclicPlayerIterator {

        private List<Player> players;
        private int currentIndex = 0;

        public CyclicPlayerIterator(List<Player> players) {
            this.players = players;
        }

        public Player current() {
            return players.get(currentIndex);
        }

        public void next() {
            currentIndex++;

            if(currentIndex >= players.size())
                currentIndex = 0;
        }

    }

}
