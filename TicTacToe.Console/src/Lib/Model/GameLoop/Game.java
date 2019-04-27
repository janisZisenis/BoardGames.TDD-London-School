package Lib.Model.GameLoop;

public interface Game {
    void playTurn();
    void render();
    boolean isOver();
}
