package HybridGaming.HybridInputPlayerAdapter;

import InputGeneration.Input.Input;

public class InputPlayerSpy implements InputPlayer {

    private int timesPlayed = 0;
    private Input playedInput;

    public int getPlayedTimes() {
        return timesPlayed;
    }

    public Input getPlayedInput() {
        return playedInput;
    }
    public void play(Input input) {
        timesPlayed++;
        playedInput = input;
    }

}
