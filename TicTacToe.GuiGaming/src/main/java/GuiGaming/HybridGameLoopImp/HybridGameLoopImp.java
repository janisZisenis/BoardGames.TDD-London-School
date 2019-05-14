package GuiGaming.HybridGameLoopImp;

import InputGeneration.Input.Input;

public class HybridGameLoopImp {

    private final HybridGame game;

    public HybridGameLoopImp(HybridGame game) {
        this.game = game;
    }

    public boolean isPlayable() {
        return !game.isOver() && game.needsInput();
    }

    public boolean isRunnable() {
        return !game.isOver() && !game.needsInput();
    }

    public void play(Input input) {
        game.play(input);
    }

    public void run() {

    }
}
