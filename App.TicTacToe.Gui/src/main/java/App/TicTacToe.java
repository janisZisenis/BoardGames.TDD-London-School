package App;

import GuiGaming.HybridGameFacade.Api.HybridGame;
import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;

public class TicTacToe implements InputProcessor {

    private final HybridGame game;

    public TicTacToe(HybridGame game) {
        this.game = game;
    }

    public void process(Input input) {
        run(input);
    }

    public void start() {
        run();
    }



    //HybridLoopImp
    private void run(Input input) {
        if(game.needsInput()) {
            game.play(input);
            run();
        }
    }

    private void run() {
        while (!game.isOver() && !game.needsInput())
            game.play();
    }

}
