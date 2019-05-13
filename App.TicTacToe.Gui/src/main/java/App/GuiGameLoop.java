package App;

import InputGeneration.Input.Input;

public class GuiGameLoop {

    private GuiGame game;

    public GuiGameLoop(GuiGame game) {
        this.game = game;
    }


    public void run() {
        while(game.isPlayable())
            game.play();
    }

    public void run(Input input) {
        if(game.needsInput()) {
            game.play(input);
            run();
        }
    }

}
