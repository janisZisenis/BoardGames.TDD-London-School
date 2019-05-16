package InteractiveGaming.HybridGameRunner;

import InputGeneration.Input.Input;

public interface HybridGame {
    boolean nextIsInputTurn();
    void playInput(Input input);
    void runToNextInputTurn();

    class CannotPlayHumanOnComputersTurn extends RuntimeException {}
}
