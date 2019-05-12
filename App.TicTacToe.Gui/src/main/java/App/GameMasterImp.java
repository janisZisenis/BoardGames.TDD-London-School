package App;

import Domain.Data.Field.Field;
import GuiGaming.GuiPlayer;
import GuiGaming.TicTacToeFacade.GameMaster;
import SequentialGaming.GameFacade.GameOverRule;
import SequentialGaming.GameFacade.Player;
import Utilities.CyclicListIterator.CyclicListIterator;

import java.util.LinkedList;

public class GameMasterImp implements GameMaster, GuiPlayer {

    private final LinkedList<Object> players = new LinkedList<>();
    private final CyclicListIterator<Object> it;
    private final GameOverRule rule;


    private GameMasterImp(Object first, GameOverRule rule) {
        players.add(first);
        it = new CyclicListIterator<>(players);
        this.rule = rule;
    }

    public GameMasterImp(GuiPlayer first, GameOverRule rule) {
        this((Object)first, rule);
    }

    public GameMasterImp(Player first, GameOverRule rule) {
        this((Object)first, rule);
    }

    public void play(Field field) {
        throwIfCurrentIsPlayer();

        GuiPlayer player = (GuiPlayer)it.getCurrent();
        player.play(field);
        it.next();
    }

    private void throwIfCurrentIsPlayer() {
        if(currentIsPlayer())
            throw new RuntimeException();
    }

    private boolean currentIsPlayer() {
        return it.getCurrent() instanceof Player;
    }

    public void simulateComputerTurns() {
        while(currentIsPlayer() && isNotGameOver()) {
            Player player = (Player) it.getCurrent();
            player.play();
            it.next();
        }
    }

    private boolean isNotGameOver() {
        return !rule.isGameOver();
    }

    public void add(Player player) {
        players.add(player);
    }

    public void add(GuiPlayer player) {
        players.add(player);
    }
}
