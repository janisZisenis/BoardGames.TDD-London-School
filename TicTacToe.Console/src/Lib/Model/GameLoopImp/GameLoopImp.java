package Lib.Model.GameLoopImp;

public class GameLoopImp {

    private final Game game;

    public GameLoopImp(Game game) {
        this.game = game;
    }

    public void run() {
        while(!game.isOver()) {
            game.playTurn();
            game.render();
        }
    }
}
