package InteractiveGaming.HybridGameImp;

import Input2D.Input.Input;

public class CountingHybridPlayerSpy implements HybridPlayer {

    private int timesIsNotInputTurn = 0;
    private int timesPlayedWithoutInput = 0;
    private int timesAskedForInputTurn = 0;

    public void play() {
        timesPlayedWithoutInput++;
    }

    public void playInput(Input input) {

    }

    public boolean isInputTurn() {
        return timesAskedForInputTurn++ >= timesIsNotInputTurn;
    }

    public void setTimesIsNotInput(int times) {
        timesIsNotInputTurn = times;
    }

    public int getTimesPlayedWithoutInput() {
        return timesPlayedWithoutInput;
    }
}
