package SequentialGaming.MultiTurn;

import SequentialGaming.DelegatingGame.Turn;

import java.util.LinkedList;
import java.util.List;

public class MultiTurn implements Turn {

    private final LinkedList<Turn> turns = new LinkedList<>();
    private final CyclicTurnIterator it = new CyclicTurnIterator(turns);
    private final MultiTurnMessenger messenger;

    public MultiTurn(Turn first, MultiTurnMessenger messenger) {
        this.turns.add(first);
        this.messenger = messenger;
    }

    public void play() {
        Turn t = it.current();

        messenger.publishTurn(t);
        t.play();

        it.next();
    }

    public void add(Turn t) {
        turns.add(t);
    }

    private class CyclicTurnIterator {

        private List<Turn> turns;
        private int currentIndex = 0;

        public CyclicTurnIterator(List<Turn> turns) {
            this.turns = turns;
        }

        public Turn current() {
            return turns.get(currentIndex);
        }

        public void next() {
            currentIndex++;

            if(currentIndex >= turns.size())
                currentIndex = 0;
        }

    }

}
