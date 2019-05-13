package App;

import InputGeneration.Input.Input;
import SequentialGaming.GameFacade.GameOverRule;

public class GuiGame {

    private final HybridPlayer player;
    private final GameOverRule rule;

    public GuiGame(GameOverRule rule, HybridPlayer player) {
        this.player = player;
        this.rule = rule;
    }

    public boolean needsInput() {
        return player.needsInput() && !isOver();
    }

    public void play(Input input) {
        player.play(input);
    }

    public boolean isPlayable() {
        return !isOver() && !needsInput();
    }

    public void play() {
        player.play();
    }

    private boolean isOver() {
        return rule.isGameOver();
    }

}
