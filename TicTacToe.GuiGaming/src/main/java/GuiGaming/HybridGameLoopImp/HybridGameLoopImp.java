package GuiGaming.HybridGameLoopImp;

import GuiGaming.HybridGameRunner.HybridGameLoop;
import InputGeneration.Input.Input;

public class HybridGameLoopImp implements HybridGameLoop {

    private final HybridGame game;

    public HybridGameLoopImp(HybridGame game) {
        this.game = game;
    }

    public boolean needsInput() {
        return game.needsInput();
    }

    public void run(Input input) {
        game.play(input);
    }

    public void run() {
        while(game.isPlayable())
            game.play();
    }

}
