package SequentialGaming.MultiTurn;

import SequentialGaming.DelegatingGame.Turn;

import java.util.LinkedList;
import java.util.List;

public class MultiTurn {

    private final LinkedList<Turn> turns = new LinkedList<>();
    private final CyclicTurnIterator it = new CyclicTurnIterator(turns);

    public MultiTurn(Turn first) {
        this.turns.add(first);
    }

    public void play() {
        it.current().play();
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
