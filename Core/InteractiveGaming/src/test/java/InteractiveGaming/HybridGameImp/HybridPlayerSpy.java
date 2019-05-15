package InteractiveGaming.HybridGameImp;

import InputGeneration.Input.Input;

public class HybridPlayerSpy implements HybridPlayer {

    private Input playedInput;
    private int timesComputer = 0;
    private int timesPlayedWithoutInput = 0;

    public void setTimesIsComputer(int times) {
        timesComputer = times;
    }
    public boolean isComputer() {
        return timesComputer > timesPlayedWithoutInput;
    }

    public Input getPlayedInput() {
        return playedInput;
    }
    public void playInput(Input input) {
        playedInput = input;
    }

    public int getTimesPlayedWithoutInput() {
        return timesPlayedWithoutInput;
    }
    public void play() {
        timesPlayedWithoutInput++;
    }
}
