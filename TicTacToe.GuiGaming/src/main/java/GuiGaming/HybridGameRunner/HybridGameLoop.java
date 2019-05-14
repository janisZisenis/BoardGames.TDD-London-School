package GuiGaming.HybridGameRunner;

import InputGeneration.Input.Input;

public interface HybridGameLoop {
    boolean nextIsHuman();
    void playHuman(Input input);
    void playComputerTurns();
}
