package com.company.TicTacToe.Game;

public class PlayerSpy implements Player {
    boolean played = false;
    int count = 0;

    public boolean hasPlayedMove() {
        return played;
    }

    public void playMove() {
        this.played = true;
        count++;
    }

    public int getPlayedMoveCount() {
        return count;
    }
}
