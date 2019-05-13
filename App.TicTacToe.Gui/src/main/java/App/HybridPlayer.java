package App;

import Domain.Data.Field.Field;
import GuiGaming.MultiGuiPlayer.GuiPlayer;
import InputGeneration.Input.Input;
import SequentialGaming.GameFacade.Player;
import Utilities.CyclicListIterator.CyclicListIterator;

import java.util.LinkedList;
import java.util.List;

public class HybridPlayer {

    private final List<Object> players = new LinkedList<>();
    private final CyclicListIterator<Object> it;


    private HybridPlayer(Object first) {
        players.add(first);
        it = new CyclicListIterator<>(players);
    }

    public HybridPlayer(GuiPlayer first) {
        this((Object)first);
    }

    public HybridPlayer(Player first) {
        this((Object)first);
    }


    public void add(GuiPlayer player) {
        players.add(player);
    }

    public void add(Player player) {
        players.add(player);
    }


    public void play() {
        if(needsInput())
            throw new RuntimeException(); //Not computer's turn

        ((Player)it.getCurrent()).play();
        it.next();
    }

    public boolean needsInput() {
        return it.getCurrent() instanceof GuiPlayer;
    }

    public void play(Input input) {
        if(!needsInput())
            throw new RuntimeException(); //Not human's turn

        Field f = makeField(input);
        ((GuiPlayer)it.getCurrent()).play(f);
        it.next();
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return new Field(row, col);
    }
}
