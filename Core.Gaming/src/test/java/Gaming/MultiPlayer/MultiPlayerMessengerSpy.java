package Gaming.MultiPlayer;

public class MultiPlayerMessengerSpy implements MultiPlayerMessenger {

    private Object published;

    public Object getPublished() {
        return published;
    }
    public void publishPlayer(Object o) {
        this.published = o;
    }
}
