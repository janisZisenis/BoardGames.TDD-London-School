package App;

import Lib.Model.Games.GameImp.GameImp;

public class Main {

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();
        GameImp ticTacToe = factory.makeTicTacToe();

        ticTacToe.play();
    }

}
