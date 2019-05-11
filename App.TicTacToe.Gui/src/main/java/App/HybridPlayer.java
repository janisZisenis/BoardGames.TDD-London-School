package App;

import Domain.Data.Field.Field;
import GuiGaming.GuiPlayer;
import SequentialGaming.GameFacade.GameOverRule;
import SequentialGaming.GameFacade.Player;

import java.util.LinkedList;
import java.util.List;

public class HybridPlayer implements GuiPlayer {

    private final LinkedList<Object> players = new LinkedList<>();
    private final CyclicGuiPlayerIterator it = new CyclicGuiPlayerIterator(players);
    private final GameOverRule rule;


    public HybridPlayer(GameOverRule rule, GuiPlayer first) {
        this.rule = rule;
        players.add(first);
    }

    public void play(Field field) {
        Object current = it.current();

        if(current instanceof GuiPlayer)
            ((GuiPlayer)current).play(field);

        it.next();
        while(it.current() instanceof Player && !rule.isGameOver()) {
            ((Player)it.current()).play();
            it.next();
        }
    }

    public void add(Player player) {
        players.add(player);
    }

    private class CyclicGuiPlayerIterator {

        private List<Object> players;
        private int currentIndex = 0;

        public CyclicGuiPlayerIterator(List<Object> players) {
            this.players = players;
        }

        public Object current() {
            return players.get(currentIndex);
        }

        public void next() {
            currentIndex++;

            if(currentIndex >= players.size())
                currentIndex = 0;
        }

    }
}
