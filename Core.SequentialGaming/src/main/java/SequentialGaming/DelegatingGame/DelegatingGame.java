package SequentialGaming.DelegatingGame;

public class DelegatingGame {

    private final GameOverRule rule;
    private final Turn turn;
    private final Renderer renderer;

    public DelegatingGame(GameOverRule rule, Renderer renderer, Turn turn) {
        this.turn = turn;
        this.renderer = renderer;
        this.rule = rule;
    }

    public void play() {
        turn.play();
    }

    public void render() {
        renderer.render();
    }

    public boolean isOver() {
        return rule.isGameOver();
    }
}
