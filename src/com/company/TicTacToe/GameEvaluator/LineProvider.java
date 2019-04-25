package com.company.TicTacToe.GameEvaluator;

import com.company.TicTacToe.Line;

public interface LineProvider {
    int getLineCount();
    Line getLine(int index);

    class LineIndexNotAvailable extends RuntimeException {}
}
