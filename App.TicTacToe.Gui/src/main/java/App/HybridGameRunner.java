package App;

import GuiGaming.HybridGameLoopImp.HybridGame;
import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;

public class HybridGameRunner implements InputProcessor {

    private final HybridGame game;

    public HybridGameRunner(HybridGame game) {
        this.game = game;
    }

    public void process(Input input) {
        if(loopIsPlayable())
            loopPlay(input);
        run();
    }

    public void run() {
        if(loopIsRunnable())
            loopRun();
    }


    private boolean loopIsPlayable() {
        return !game.isOver() && game.needsInput();
    }

    private void loopPlay(Input input) {
        game.play(input);
    }

    private void loopRun() {
        while(loopIsRunnable())
            game.play();
    }

    private boolean loopIsRunnable() {
        return !game.isOver() && !game.needsInput();
    }

}
