package App;

import Lib.Model.Game.Game;

public class Main {

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();
        Game ticTacToe = factory.makeTicTacToe();

        ticTacToe.play();
    }

}
