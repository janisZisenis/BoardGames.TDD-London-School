package GuiGaming.HybridGameRunner;


import InputGeneration.Input.Input;

public class HybridGameLoopSpy implements HybridGameLoop {

    private boolean needsInput = false;

    private Input runInput;
    private boolean didRunInput = false;
    private boolean didRun = false;


    public void setNeedsInput(boolean b) {
        this.needsInput = b;
    }
    public boolean needsInput() {
        return needsInput;
    }

    public boolean hasRun() {
        return didRun;
    }
    public void run() {
        didRun = true;
    }

    public boolean hasRunInput() {
        return didRunInput;
    }
    public Input getRunInput() {
        return runInput;
    }
    public void run(Input input) {
        didRunInput = true;
        runInput = input;
    }
}
