package GuiGaming.HybridGameLoopImp;

import InputGeneration.Input.Input;

public interface HybridGame {
    boolean isPlayable();
    void play();

    boolean needsInput();
    void play(Input input);
}
