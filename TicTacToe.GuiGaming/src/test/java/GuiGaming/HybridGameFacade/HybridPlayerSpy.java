package GuiGaming.HybridGameFacade;

import InputGeneration.Input.Input;

public class HybridPlayerSpy extends HybridPlayerStub {

    private int timesPlayed = 0;
    private Input playedInput;

    public int getPlayedTimes() {
        return timesPlayed;
    }
    public void play() {
        timesPlayed++;
    }

    public Input getPlayedInput() {
        return playedInput;
    }
    public void play(Input input) {
        playedInput = input;
    }

}
