package GuiGaming.HybridGameLoopImp;

import InputGeneration.Input.Input;

public class HybridGameStub implements HybridGame {

    private boolean isOver = false;
    private int timesNeedsInput = 0;

    public void setIsOver(boolean isOver) {
        this.isOver = isOver;
    }
    public boolean isOver() {
        return isOver;
    }

    public void setTimesNeedsInput(int times) {
        this.timesNeedsInput = times;
    }
    public boolean needsInput() {
        return timesNeedsInput-- > 0;
    }

    public void play(Input input) {

    }

    public void play() {

    }
}
