package SequentialGaming.GameLoopImp;

import SequentialGaming.MessagingGameLoop.GameLoop;

public class GameLoopImp implements GameLoop {

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
