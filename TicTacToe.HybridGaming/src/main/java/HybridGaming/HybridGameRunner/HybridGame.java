package HybridGaming.HybridGameRunner;

import InputGeneration.Input.Input;

public interface HybridGame {
    boolean nextIsHuman();
    void playHuman(Input input);
    void playComputerTurns();

    class CannotPlayHumanOnComputersTurn extends RuntimeException {}
}
