package App;

import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;

public class TicTacToe implements InputProcessor {

    private final GuiGameLoop loop;

    public TicTacToe(GuiGameLoop loop) {
        this.loop = loop;
    }

    public void process(Input input) {
        loop.run(input);
    }

    public void start() {
        loop.run();
    }
}
