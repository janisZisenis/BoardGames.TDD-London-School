package com.company.TicTacToe.BoardPresenter;
import com.company.TicTacToe.Line;

public interface WinningLineProvider {
    boolean hasWinningLine();
    Line getWinningLine();

    class NoWinningLineAvailable extends RuntimeException {}
}
