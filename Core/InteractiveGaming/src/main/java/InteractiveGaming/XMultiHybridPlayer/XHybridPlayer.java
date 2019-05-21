package InteractiveGaming.XMultiHybridPlayer;

import Input2D.Input.Input;
import InteractiveGaming.InputTurnProcessor.IsInputTurnProvider;

public interface XHybridPlayer extends IsInputTurnProvider {
    void play();
    void playInput(Input input);
    boolean isInputTurn();

    class CannotPlayWithInput extends RuntimeException {}
    class CannotPlayWithoutInput extends RuntimeException {}

}
