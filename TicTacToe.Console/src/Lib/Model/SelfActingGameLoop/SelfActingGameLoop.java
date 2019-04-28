package Lib.Model.SelfActingGameLoop;

import Lib.Model.TicTacToe.GameLoop;

public class SelfActingGameLoop implements GameLoop {

    private final GameOverRule rule;
    private final Turn turn;
    private final Renderer renderer;

    public SelfActingGameLoop(GameOverRule rule, Turn turn, Renderer renderer) {
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
