package com.company.Model.GameLoop.TwoPlayerTurn.VerboseTwoPlayerTurn;

public class TurnMessageViewSpy implements TurnMessageView {
    private Object shownPlayer;

    public Object getShownPlayer() {
        return shownPlayer;
    }
    public void showTurnMessageFor(Object player) {
        shownPlayer = player;
    }
}
