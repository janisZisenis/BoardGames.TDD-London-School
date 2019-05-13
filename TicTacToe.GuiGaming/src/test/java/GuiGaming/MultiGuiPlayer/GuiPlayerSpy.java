package GuiGaming.MultiGuiPlayer;

import InputGeneration.Input.Input;

public class GuiPlayerSpy implements GuiPlayer {

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
