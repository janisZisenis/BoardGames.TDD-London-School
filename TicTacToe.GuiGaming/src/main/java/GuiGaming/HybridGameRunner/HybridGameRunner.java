package GuiGaming.HybridGameRunner;

import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;

public class HybridGameRunner implements InputProcessor {

    private final HybridGame loop;

    public HybridGameRunner(HybridGame loop) {
        this.loop = loop;
    }

    public void run() {
        loop.playComputerTurns();
    }

    public void process(Input input) {
        if(loop.nextIsHuman()) {
            loop.playHuman(input);
            loop.playComputerTurns();
        }
    }
}

