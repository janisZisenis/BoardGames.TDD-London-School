package com.company.App;

import com.company.Core.GameLoop.GameLoop;
import com.company.TicTacToe.Board.Board;

public class Main {

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();

        Board board = factory.makeDisplayedBoard();

        GameLoop loop = factory.makeTicTacToeGameLoop(board);
        loop.play();
    }

}
