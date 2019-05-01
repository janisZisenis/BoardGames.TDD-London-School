package Lib.TwoPlayerTurn.MessagingTwoPlayerTurn;

public class TurnMessengerSpy implements TurnMessenger {
    private Object shownPlayer;

    public Object getPlayerForPublishedTurnMessage() {
        return shownPlayer;
    }
    public void publishTurnMessageFor(Object player) {
        shownPlayer = player;
    }
}
