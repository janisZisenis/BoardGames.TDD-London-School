package App;

import Gaming.GameImp.Game;

public class Main {

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();
        Game ticTacToe = factory.makeGame();

        ticTacToe.play();
    }

}
