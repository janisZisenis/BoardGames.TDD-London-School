package SequentialGaming.GameLoop;

public class GameLoop {

    private final Game game;

    public GameLoop(Game game) {
        this.game = game;
    }

    public void run() {
        while(isRunnung())
            runNextIteration();
    }

    private void runNextIteration() {
        game.play();
        game.render();
    }

    private boolean isRunnung() {
        return !game.isOver();
    }
}
