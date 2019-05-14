package GuiGaming.HybridGameLoopImp;

import InputGeneration.Input.Input;

public class HybridGameSpy extends HybridGameStub {

    private Input playedInput;

    public Input getPlayedInput() {
        return playedInput;
    }
    public void play(Input input) {
        playedInput = input;
    }

    public void play() {

    }

}
