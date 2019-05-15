package InteractiveGaming.HybridGameRunner;


import InputGeneration.Input.Input;

public class HybridGameSpy implements HybridGame {

    private boolean nextIsInputTurn = false;

    private Input playedInput;
    private boolean didPlayInput = false;
    private boolean didRunToNextInputTurn = false;

    public void SetNextIsInputTurn(boolean b) {
        this.nextIsInputTurn = b;
    }
    public boolean nextIsInputTurn() {
        return nextIsInputTurn;
    }

    public boolean hasRunToNextInputTurn() {
        return didRunToNextInputTurn;
    }
    public void runToNextInputTurn() {
        didRunToNextInputTurn = true;
    }

    public boolean hasPlayedInput() {
        return didPlayInput;
    }
    public Input getPlayedInput() {
        return playedInput;
    }
    public void playInput(Input input) {
        didPlayInput = true;
        playedInput = input;
    }
}
