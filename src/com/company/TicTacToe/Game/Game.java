package com.company.TicTacToe.Game;

public class Game {
    private final Player first;
    private final Player second;
    private Player current;

    private int count = 0;

    public Game(Player first, Player second) {
        this.first = first;
        this.second = second;
        this.current = first;
    }

    public void play() {
        current.playMove();
        current = current == first ? second : first;

        count++;
    }
}
