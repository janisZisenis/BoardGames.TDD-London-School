package InteractiveGaming.HybridGameImp;

import Input2D.Input.Input;
import InteractiveGaming.InputProcessors.InputTurnProcessor.IsInputTurnProvider;

public interface HybridPlayer extends IsInputTurnProvider {
    void play();
    void playInput(Input input);
    boolean isInputTurn();
}
