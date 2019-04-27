package Lib.Model.RenderingGameLoop.TwoPlayerTurn.VerboseTwoPlayerTurn;

import Lib.Model.RenderingGameLoop.TwoPlayerTurn.Player;
import Lib.Model.RenderingGameLoop.TwoPlayerTurn.TwoPlayerTurn;

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
