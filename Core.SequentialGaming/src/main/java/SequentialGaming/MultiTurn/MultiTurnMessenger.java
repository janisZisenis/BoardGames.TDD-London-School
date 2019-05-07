package SequentialGaming.MultiTurn;

public interface MultiTurnMessenger {
    void publishTurn(Object o);

    public class NoTurnMessageForObjectAvailable extends RuntimeException {}
}
