package InteractiveGaming.XMultiHybridPlayer;

import Input2D.Input.Input;

public interface XHybridPlayer {
    void play();
    void playInput(Input input);
    boolean isInputTurn();

    class CannotPlayWithInput extends RuntimeException {}

}
