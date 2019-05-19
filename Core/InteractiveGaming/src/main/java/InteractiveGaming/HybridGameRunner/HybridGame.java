package InteractiveGaming.HybridGameRunner;

import Input2D.Input.Input;

public interface HybridGame {
    boolean nextIsInputTurn();
    void playInput(Input input);
    void runToNextInputTurn();

    class CannotPlayHumanOnComputersTurn extends RuntimeException {}
}
