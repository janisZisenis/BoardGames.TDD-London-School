package Messaging.Turn.MessagingTurn;

public interface TurnMessenger {
    void publishTurnMessageFor(Object player);

    class NoTurnMessageForObjectAvailable extends RuntimeException {}
}
