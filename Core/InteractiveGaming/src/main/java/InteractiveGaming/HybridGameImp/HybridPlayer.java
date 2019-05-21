package InteractiveGaming.HybridGameImp;

import Input2D.Input.Input;

public interface HybridPlayer {
    boolean isNotInputTurn();
    void playInput(Input input);
    void play();

    class CannotPlayHumanOnComputersTurn extends RuntimeException {}
    class CannotPlayWithInput extends RuntimeException {}
}
