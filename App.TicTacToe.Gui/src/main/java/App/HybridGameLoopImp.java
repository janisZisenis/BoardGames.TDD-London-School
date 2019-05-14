package App;

import GuiGaming.HybridGameRunner.HybridGameLoop;
import GuiGaming.MultiHybridPlayer.HybridPlayer;
import InputGeneration.Input.Input;
import SequentialGaming.GameFacade.GameOverRule;

public class HybridGameLoopImp implements HybridGameLoop {

    private final GameOverRule rule;
    private final HybridPlayer player;

    public HybridGameLoopImp(GameOverRule rule, HybridPlayer player) {
        this.player = player;
        this.rule = rule;
    }

    public boolean needsInput() {
        return gameNeedsInput();
    }

    public void run(Input input) {
        play(input);
        run();
    }

    public void run() {
        while(isPlayable())
            play();
    }

    //HybridGame
    private boolean isPlayable() {
        return !rule.isGameOver() && !player.needsInput();
    }

    private void play() {
        player.play();
    }

    private boolean gameNeedsInput() {
        return player.needsInput() && !rule.isGameOver();
    }

    private void play(Input input) {
        player.play(input);
    }
}
