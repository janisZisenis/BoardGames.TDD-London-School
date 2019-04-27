package Lib.Model.GameLoop.TwoPlayerTurn.VerboseTwoPlayerTurn;

import Lib.Model.GameLoop.TwoPlayerTurn.Player;
import Lib.Model.GameLoop.TwoPlayerTurn.TwoPlayerTurn;

public class VerboseTwoPlayerTurn extends TwoPlayerTurn {
    private TurnMessageView view;

    public VerboseTwoPlayerTurn(Player first, Player second, TurnMessageView view) {
        super(first, second);
        this.view = view;
    }

    public void play() {
        view.showTurnMessageFor(current);
        super.play();
    }

}
