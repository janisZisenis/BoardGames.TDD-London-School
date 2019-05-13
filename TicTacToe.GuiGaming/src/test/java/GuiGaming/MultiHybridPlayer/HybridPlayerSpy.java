package GuiGaming.MultiHybridPlayer;

import InputGeneration.Input.Input;

public class HybridPlayerSpy implements HybridPlayer {

    private int timesPlayed = 0;
    private Input playedInput;
    private boolean needsInput = false;

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

    public void setNeedsInput(boolean needsInput) {
        this.needsInput = needsInput;
    }
    public boolean needsInput() {
        return needsInput;
    }

}
