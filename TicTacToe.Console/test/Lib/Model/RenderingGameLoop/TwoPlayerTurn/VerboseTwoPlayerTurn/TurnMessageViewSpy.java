package Lib.Model.RenderingGameLoop.TwoPlayerTurn.VerboseTwoPlayerTurn;

public class TurnMessageViewSpy implements TurnMessageView {
    private Object shownPlayer;

    public Object getShownPlayer() {
        return shownPlayer;
    }
    public void showTurnMessageFor(Object player) {
        shownPlayer = player;
    }
}
