package GuiGaming.MultiGuiPlayer;

import Domain.Data.Field.Field;
import GuiGaming.GuiMultiPlayer.GuiPlayer;

import java.util.LinkedList;
import java.util.List;

public class MultiGuiPlayer implements GuiPlayer {

    private final LinkedList<GuiPlayer> players = new LinkedList<>();
    private final CyclicGuiPlayerIterator it = new CyclicGuiPlayerIterator(players);


    public MultiGuiPlayer(GuiPlayer first) {
        players.add(first);
    }

    public void play(Field field) {
        GuiPlayer current = it.current();
        current.play(field);
        it.next();
    }

    public void add(GuiPlayer player) {
        players.add(player);
    }

    private class CyclicGuiPlayerIterator {

        private List<GuiPlayer> players;
        private int currentIndex = 0;

        public CyclicGuiPlayerIterator(List<GuiPlayer> players) {
            this.players = players;
        }

        public GuiPlayer current() {
            return players.get(currentIndex);
        }

        public void next() {
            currentIndex++;

            if(currentIndex >= players.size())
                currentIndex = 0;
        }

    }
}
