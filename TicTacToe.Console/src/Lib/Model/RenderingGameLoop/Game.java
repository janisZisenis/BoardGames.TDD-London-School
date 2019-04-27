package Lib.Model.RenderingGameLoop;

public interface Game {
    void playTurn();
    void render();
    boolean isOver();
}
