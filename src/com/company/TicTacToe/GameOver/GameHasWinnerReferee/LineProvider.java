package com.company.TicTacToe.GameOver.GameHasWinnerReferee;

public interface LineProvider {
    int getLineCount();
    Line getLine(int index);
}
