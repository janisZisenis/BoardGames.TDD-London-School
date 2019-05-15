package Gaming.GameLoopImp;

import Gaming.MessagingGameLoop.GameLoop;

public class GameLoopImp implements GameLoop {

    private final Game game;

    public GameLoopImp(Game game) {
        this.game = game;
    }

    public void run() {
        while(isPlayable())
            runNextIteration();
    }

    private void runNextIteration() {
        game.play();
        game.render();
    }

    private boolean isPlayable() {
        return !game.isOver();
    }
}
