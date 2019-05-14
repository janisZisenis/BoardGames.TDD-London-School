package App;

import GuiGaming.HybridGameImp.HybridPlayer;
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
        return player.isComputer() && !isOver();
    }

    public void play(Input input) {
        player.playHuman(input);
    }

    public boolean isPlayable() {
        return !isOver() && !needsInput();
    }

    public void play() {
        player.playComputer();
    }

    private boolean isOver() {
        return rule.isGameOver();
    }

}
