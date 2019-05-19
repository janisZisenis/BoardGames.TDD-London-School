package InteractiveGaming.HybridGameImp;

import Input2D.Input.Input;

public interface HybridPlayer {
    boolean isComputer();
    void playInput(Input input);
    void play();

    class CannotPlayHumanOnComputersTurn extends RuntimeException {}
    class CannotPlayComputerOnHumansTurn extends RuntimeException {}
}
