package GuiGaming.HybridGameRunner;

import InputGeneration.Input.Input;

public interface HybridGameLoop {
    boolean needsInput();
    void run(Input input);
    void run();
}
