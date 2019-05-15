package InteractiveGaming.HybridInputPlayerAdapter;

import InputGeneration.Input.Input;

public class InputPlayerSpy implements InputPlayer {

    private Input playedInput;

    public Input getPlayedInput() {
        return playedInput;
    }
    public void play(Input input) {
        playedInput = input;
    }

}
