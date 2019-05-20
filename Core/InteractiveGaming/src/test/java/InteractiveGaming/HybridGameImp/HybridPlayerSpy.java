package InteractiveGaming.HybridGameImp;

import Input2D.Input.Input;

public class HybridPlayerSpy implements HybridPlayer {

    private Input playedInput;
    private int timesPlayableWithoutInput = 0;
    private int timesPlayedWithoutInput = 0;

    public void setTimesPlayableWithoutInput(int times) {
        timesPlayableWithoutInput = times;
    }
    public boolean isNotInputTurn() {
        return timesPlayableWithoutInput > timesPlayedWithoutInput;
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

    public void setNextIsInputTurn() {
        setTimesPlayableWithoutInput(0);
    }

    public void setNextIsNotInputTurn() {
        setTimesPlayableWithoutInput(1);
    }
}
