package Lib.Model.RenderingGameLoop;

public class RenderingGameLoop {

    private final Game game;

    public RenderingGameLoop(Game game) {
        this.game = game;
    }

    public void run() {
        while(!game.isOver()) {
            game.playTurn();
            game.render();
        }
    }
}
