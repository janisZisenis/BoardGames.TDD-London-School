package Presentation.ChoosePlayerViewPresenter;

import Domain.Board.BoardDecorators.ObservableBoard.Observer;
import Presentation.ChoosePlayerViewPresenter.Api.ChoosePlayerViewDelegate;

import java.util.LinkedList;
import java.util.List;

public class ChoosePlayerViewPresenter implements ChoosePlayerViewDelegate {

    private final ChoosePlayerView view;
    private final List<Observer> observers = new LinkedList<>();

    public ChoosePlayerViewPresenter(ChoosePlayerView view) {
        this.view = view;
        selectOnlyHuman();
    }

    public void onHumanClicked() {
        selectOnlyHuman();
        notifyObservers();
    }

    public void onHumbleClicked() {
        selectOnlyHumble();
        notifyObservers();
    }

    public void onInvincibleClicked() {
        selectOnlyInvincible();
        notifyObservers();
    }

    private void selectOnlyHuman() {
        view.selectHuman();
        view.deselectHumble();
        view.deselectInvincible();
    }

    private void selectOnlyHumble() {
        view.deselectHuman();
        view.selectHumble();
        view.deselectInvincible();
    }

    private void selectOnlyInvincible() {
        view.deselectHuman();
        view.deselectHumble();
        view.selectInvincible();
    }

    public boolean hasDistinctPlayerType() {
        return onlyHumanIsSelected() || onlyHumbleIsSelected() || onlyInvincibleIsSelected();
    }

    private boolean onlyHumanIsSelected() {
        return view.isHumanSelected() && !(view.isHumbleSelected() || view.isInvincibleSelected());
    }

    private boolean onlyHumbleIsSelected() {
        return view.isHumbleSelected() && !(view.isInvincibleSelected() || view.isHumanSelected());
    }

    private boolean onlyInvincibleIsSelected() {
        return view.isInvincibleSelected() && !(view.isHumanSelected() || view.isHumbleSelected());
    }

    public PlayerType getDistinctPlayerType() {
        throwIfNoDistinctPlayerTypeAvailable();

        return getPlayerType();
    }

    private PlayerType getPlayerType() {
        if(view.isInvincibleSelected())
            return PlayerType.Invincible;
        if(view.isHumbleSelected())
            return PlayerType.Humble;

        return PlayerType.Human;
    }

    private void throwIfNoDistinctPlayerTypeAvailable() {
        if(!hasDistinctPlayerType())
            throw new NoDistinctPlayerType();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    private void notifyObservers() {
        for (Observer o : observers)
            o.update();
    }

    public class NoDistinctPlayerType extends RuntimeException {}
}
