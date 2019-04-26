package com.company.Model.GameLoop.TwoPlayerTurn.VerboseTwoPlayerTurn;

import com.company.Model.GameLoop.Turn;
import com.company.Model.GameLoop.TwoPlayerTurn.Player;

public class VerboseTwoPlayerTurn implements Turn {
    private final Player first;
    private final Player second;
    private Player current;
    private TurnMessageView view;

    public VerboseTwoPlayerTurn(Player first, Player second, TurnMessageView view) {
        this.first = this.current = first;
        this.second = second;
        this.view = view;
    }

    public void play() {
        view.showTurnMessageFor(current);
        playMove();
        togglePlayer();
    }

    private void playMove() {
        current.playMove();
    }

    private void togglePlayer() {
        current = (current == first) ? second : first;
    }
}
