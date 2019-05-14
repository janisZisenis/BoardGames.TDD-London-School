package GuiGaming.HybridGameRunner;


import InputGeneration.Input.Input;

public class HybridGameLoopSpy implements HybridGameLoop {

    private boolean needsInput = false;

    private Input playedInput;
    private boolean didPlayInput = false;
    private boolean didPlayComputerTurns = false;


    public void nextIsHuman(boolean b) {
        this.needsInput = b;
    }
    public boolean nextIsHuman() {
        return needsInput;
    }

    public boolean hasPlayedComputerTurns() {
        return didPlayComputerTurns;
    }
    public void playComputerTurns() {
        didPlayComputerTurns = true;
    }

    public boolean hasPlayedInput() {
        return didPlayInput;
    }
    public Input getPlayedInput() {
        return playedInput;
    }
    public void playHuman(Input input) {
        didPlayInput = true;
        playedInput = input;
    }
}
