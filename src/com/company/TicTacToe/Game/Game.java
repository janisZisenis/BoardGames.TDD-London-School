package com.company.TicTacToe.Game;

public class Game {
    private final Player first;
    private final Player second;
    private Player current;

    public Game(Player first, Player second) {
        this.first = first;
        this.second = second;
        this.current = first;
    }

    public void play() {
        playMove();
        togglePlayer();
    }

    private void playMove() {
        current.playMove();
    }

    private void togglePlayer() {
        current = current == first ? second : first;
    }
}
