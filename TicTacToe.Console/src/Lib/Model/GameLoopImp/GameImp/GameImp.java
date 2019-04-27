package Lib.Model.GameLoopImp.GameImp;

import Lib.Model.GameLoopImp.Game;

public class GameImp implements Game {

    private final Turn turn;
    private final GameOverRule rule;
    private final Renderer renderer;

    public GameImp(Turn turn, GameOverRule rule, Renderer renderer) {
        this.turn = turn;
        this.rule = rule;
        this.renderer = renderer;
    }

    public void playTurn() {
        turn.play();
    }

    public void render() {
        renderer.render();
    }

    public boolean isOver() {
        return rule.isGameOver();
    }
}
