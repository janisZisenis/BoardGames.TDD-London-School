package InteractiveGaming.HybridGameImp;

import InputGeneration.Input.Input;

public class HybridPlayerSpy implements HybridPlayer {

    private Input playedInput;
    private int timesComputer = 0;
    private int timesComputerPlayed = 0;

    public void setTimesIsComputer(int times) {
        timesComputer = times;
    }
    public boolean isComputer() {
        return timesComputer > timesComputerPlayed;
    }

    public Input getPlayedInput() {
        return playedInput;
    }
    public void playHuman(Input input) {
        playedInput = input;
    }

    public int getTimesPlayedComputer() {
        return timesComputerPlayed;
    }
    public void playComputer() {
        timesComputerPlayed++;
    }
}
