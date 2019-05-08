package SequentialGaming.MultiTurn;

public class MultiTurnMessengerSpy implements MultiTurnMessenger {

    private Object published;

    public Object getPublished() {
        return published;
    }
    public void publishTurn(Object o) {
        this.published = o;
    }
}
