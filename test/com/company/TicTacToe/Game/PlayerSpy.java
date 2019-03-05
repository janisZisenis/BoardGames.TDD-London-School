package com.company.TicTacToe.Game;

public class PlayerSpy implements Player {
    private int count = 0;

    public void playMove() {
        count++;
    }

    public int getPlayedMoveCount() {
        return count;
    }
}
