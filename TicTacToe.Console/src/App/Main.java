package App;

import Lib.CLI.View.TicTacToeView.ConsoleReceptionist;
import Lib.Model.Board.Board;
import Lib.Model.GameLoopImp.GameImp.Renderer;
import Lib.Model.GameLoopImp.GameLoopImp;
import Lib.Model.TicTacToe.TicTacToe;

public class Main {

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();
        Board board = factory.makeBoard();

        ConsoleReceptionist receptionist = new ConsoleReceptionist();
        Renderer renderer = factory.makeBoardRenderer(board);
        GameLoopImp loop = factory.makeRenderingGameLoop(board);
        TicTacToe ticTacToe = new TicTacToe(receptionist, renderer, loop);

        ticTacToe.proceed();
    }

}
