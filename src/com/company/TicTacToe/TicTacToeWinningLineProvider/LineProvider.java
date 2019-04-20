package com.company.TicTacToe.TicTacToeWinningLineProvider;

import com.company.TicTacToe.Line;

public interface LineProvider {
    int getLineCount();
    Line getLine(int index);

    public class LineIndexNotAvailable extends RuntimeException {}
}
