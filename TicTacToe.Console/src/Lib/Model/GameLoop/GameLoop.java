package Lib.Model.GameLoop;

public class GameLoop {

    private final Game game;

    public GameLoop(Game game) {
        this.game = game;
    }

    public void run() {
        while(!game.isOver()) {
            game.playTurn();
            game.render();
        }
    }
}
