package InteractiveGaming.XHybridInputPlayerAdapter;

import Input2D.Input.Input;
import InteractiveGaming.XHybridInputPlayerAdapter.InputPlayer;

public class InputPlayerSpy implements InputPlayer {

    private Input playedInput;

    public Input getPlayedInput() {
        return playedInput;
    }
    public void play(Input input) {
        playedInput = input;
    }

}
