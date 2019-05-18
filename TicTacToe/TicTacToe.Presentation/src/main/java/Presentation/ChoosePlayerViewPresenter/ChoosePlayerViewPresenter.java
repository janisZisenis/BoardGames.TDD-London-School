package Presentation.ChoosePlayerViewPresenter;

import Utilities.Observer.Observer;
import Presentation.ChoosePlayerViewPresenter.Api.ChoosePlayerViewDelegate;

import java.util.LinkedList;
import java.util.List;

import static Presentation.ChoosePlayerViewPresenter.PlayerType.Human;
import static Presentation.ChoosePlayerViewPresenter.PlayerType.HumbleCPU;
import static Presentation.ChoosePlayerViewPresenter.PlayerType.InvincibleCPU;

public class ChoosePlayerViewPresenter implements ChoosePlayerViewDelegate {

    private final ChoosePlayerView view;
    private final List<Observer> observers = new LinkedList<>();

    public ChoosePlayerViewPresenter(ChoosePlayerView view) {
        this.view = view;
        view.setSelectedPlayerType(Human);
    }

    public void onHumanClicked() {
        view.setSelectedPlayerType(Human);
        notifyObservers();
    }

    public void onHumbleCPUClicked() {
        view.setSelectedPlayerType(HumbleCPU);
        notifyObservers();
    }

    public void onInvincibleCPUClicked() {
        view.setSelectedPlayerType(InvincibleCPU);
        notifyObservers();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    private void notifyObservers() {
        for (Observer o : observers)
            o.update();
    }

}
