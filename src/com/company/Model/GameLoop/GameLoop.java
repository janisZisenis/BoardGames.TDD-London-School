package com.company.Model.GameLoop;

public class GameLoop {

    private Turn turn;
    private final GameOverRule rule;

    public GameLoop(Turn turn, GameOverRule rule) {
        this.turn = turn;
        this.rule = rule;
    }

    public void run() {
        while(!rule.isGameOver())
            turn.play();
    }
}
