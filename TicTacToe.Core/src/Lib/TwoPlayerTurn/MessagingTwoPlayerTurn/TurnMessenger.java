package Lib.TwoPlayerTurn.MessagingTwoPlayerTurn;

public interface TurnMessenger {
    void publishTurnMessageFor(Object player);

    class NoTurnMessageForObjectAvailable extends RuntimeException {}
}
