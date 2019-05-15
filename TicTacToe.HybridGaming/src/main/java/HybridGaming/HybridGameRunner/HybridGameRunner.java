package HybridGaming.HybridGameRunner;

import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;

public class HybridGameRunner implements InputProcessor {

    private final HybridGame game;

    public HybridGameRunner(HybridGame game) {
        this.game = game;
    }

    public void run() {
        game.playComputerTurns();
    }

    public void process(Input input) {
        if(game.nextIsHuman()) {
            game.playHuman(input);
            game.playComputerTurns();
        }
    }
}

