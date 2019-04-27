package App;

import Lib.Model.TicTacToe.TicTacToe;

public class Main {

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();
        TicTacToe ticTacToe = factory.makeTicTacToe();

        ticTacToe.proceed();
    }

}
