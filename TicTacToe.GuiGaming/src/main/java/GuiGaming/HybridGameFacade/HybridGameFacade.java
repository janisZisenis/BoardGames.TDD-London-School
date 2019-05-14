package GuiGaming.HybridGameFacade;

import GuiGaming.MultiHybridPlayer.HybridPlayer;
import InputGeneration.Input.Input;
import SequentialGaming.GameFacade.GameOverRule;

public class HybridGameFacade {

    private final HybridPlayer player;
    private final GameOverRule rule;

    public HybridGameFacade(GameOverRule rule, HybridPlayer player) {
        this.rule = rule;
        this.player = player;
    }

    public boolean needsInput() {
        return player.needsInput();
    }

    public void play() {
        player.play();
    }

    public void play(Input input) {
        player.play(input);
    }

    public boolean isOver() {
        return rule.isGameOver();
    }
}
