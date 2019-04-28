package Lib.Model.GameLoopImp;

import Lib.Model.Games.GameImp.GameLoop;

public class GameLoopImp implements GameLoop {

    private final GameOverRule rule;
    private final Turn turn;
    private final Renderer renderer;

    public GameLoopImp(GameOverRule rule, Turn turn, Renderer renderer) {
        this.rule = rule;
        this.turn = turn;
        this.renderer = renderer;
    }

    public void run() {
        while(!rule.isGameOver()) {
            turn.play();
            renderer.render();
        }
    }
}
