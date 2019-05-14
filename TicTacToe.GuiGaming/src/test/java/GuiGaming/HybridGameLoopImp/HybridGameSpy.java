package GuiGaming.HybridGameLoopImp;

import InputGeneration.Input.Input;

public class HybridGameSpy implements HybridGame {

    private int timesPlayable = 0;
    private int timesPlayed = 0;
    private int timesNeedsInput;
    private Input playedInput;

    public void setTimesPlayable(int times) {
        timesPlayable = times;
    }
    public boolean isPlayable() {
        return timesPlayable-- > 0;
    }

    public int getPlayedTimes() {
        return timesPlayed;
    }
    public void play() {
        timesPlayed++;
    }

    public void setTimesNeedsInput(int times) {
        this.timesNeedsInput = times;
    }
    public boolean needsInput() {
        return timesNeedsInput-- > 0;
    }

    public Input getPlayedInput() {
        return playedInput;
    }
    public void play(Input input) {
        playedInput = input;
    }
}
