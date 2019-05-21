package Utilities.Observer;

public class ObserverSpy implements Observer {

    private boolean updated = false;

    public void update() { updated = true; }

    public boolean wasUpdated() {
        return updated;
    }

}
