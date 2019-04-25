package com.company.Model.Board.ObservableBoard;

public class ObserverSpy implements Observer {

    private boolean updated = false;

    public void update() { updated = true; }

    public boolean wasUpdated() {
        return updated;
    }

}
