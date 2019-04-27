package Lib.Model.GameLoop.GameImp.TwoPlayerTurn;
import Lib.Model.GameLoop.GameImp.Turn;

public class TwoPlayerTurn implements Turn {
    private final Player first;
    private final Player second;
    protected Player current;

    public TwoPlayerTurn(Player first, Player second) {
        this.first = this.current = first;
        this.second = second;
    }

    public void play() {
        playMove();
        togglePlayer();
    }

    private void playMove() {
        current.playMove();
    }

    private void togglePlayer() {
        current = (current == first) ? second : first;
    }
}
