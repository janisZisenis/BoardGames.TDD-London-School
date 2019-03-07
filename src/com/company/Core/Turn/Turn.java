package com.company.Core.Turn;

public class Turn {
    private final Player first;
    private final Player second;
    private Player current;

    public Turn(Player first, Player second) {
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
