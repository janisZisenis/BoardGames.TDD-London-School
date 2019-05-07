package SequentialGaming.GameLoopImp;

public class GameLoopImp {

    private final Game game;

    public GameLoopImp(Game game) {
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
