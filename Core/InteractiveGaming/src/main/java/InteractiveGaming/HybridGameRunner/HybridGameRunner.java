package InteractiveGaming.HybridGameRunner;

import Gaming.GameLoopImp.Api.GameLoop;
import Input2D.Input.Input;
import Input2D.InputProcessor;

public class HybridGameRunner implements InputProcessor, GameLoop {

    private final HybridGame game;

    public HybridGameRunner(HybridGame game) {
        this.game = game;
    }

    public void process(Input input) {
       if(nextIsInputTurn())
            runInput(input);
    }

    private void runInput(Input input) {
        game.playInput(input);
        run();
    }

    public void run() {
        game.runToNextInputTurn();
    }

    private boolean nextIsInputTurn() {
        return game.nextIsInputTurn();
    }
}

