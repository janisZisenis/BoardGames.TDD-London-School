package GuiGaming.HybridGameFacade;

import GuiGaming.MultiHybridPlayer.HybridPlayer;
import InputGeneration.Input.Input;

public class HybridPlayerStub implements HybridPlayer {

    private boolean needsInput = false;

    public void play() {}
    public void play(Input input) {}

    public void setNeedsInput(boolean needsInput) {
        this.needsInput = needsInput;
    }
    public boolean needsInput() {
        return needsInput;
    }

}
