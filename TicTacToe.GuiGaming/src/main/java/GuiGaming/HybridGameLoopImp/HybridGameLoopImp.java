package GuiGaming.HybridGameLoopImp;

import GuiGaming.HybridGameRunner.HybridGameLoop;
import InputGeneration.Input.Input;

public class HybridGameLoopImp implements HybridGameLoop {

    private final HybridGame game;

    public HybridGameLoopImp(HybridGame game) {
        this.game = game;
    }

    public boolean nextIsHuman() {
        return game.needsInput();
    }

    public void playHuman(Input input) {
        game.play(input);
    }

    public void playComputerTurns() {
        while(game.isPlayable())
            game.play();
    }

}
