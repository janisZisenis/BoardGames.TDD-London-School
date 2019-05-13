package GuiGaming.MultiHybridPlayer;

import InputGeneration.Input.Input;

public interface HybridPlayer {
    void play();
    void play(Input input);
    boolean needsInput();

    class NeedsInputButWasPlayedWithout extends RuntimeException {}
    class DoesNotNeedInputButWasPlayedWith extends RuntimeException {}
}
