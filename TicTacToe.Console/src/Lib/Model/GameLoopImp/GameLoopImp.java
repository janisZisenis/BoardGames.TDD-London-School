package Lib.Model.GameLoopImp;

import Lib.Model.TicTacToe.GameLoop;

public class GameLoopImp implements GameLoop {

    private final Game game;

    public GameLoopImp(Game game) {
        this.game = game;
    }

    public void run() {
        while(!game.isOver()) {
            game.playTurn();
            game.render();
        }
    }
}
