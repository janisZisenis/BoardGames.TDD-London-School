package Presentation.ChoosePlayerViewPresenter;

import Presentation.ChoosePlayerViewPresenter.Api.ChoosePlayerViewDelegate;

public class ChoosePlayerViewPresenter implements ChoosePlayerViewDelegate {

    private ChoosePlayerView view;

    public ChoosePlayerViewPresenter(ChoosePlayerView view) {
        this.view = view;
        selectOnlyHuman();
    }

    public void onHumanClicked() {
        selectOnlyHuman();
    }

    public void onHumbleClicked() {
        selectOnlyHumble();
    }

    public void onInvincibleClicked() {
        view.selectInvincible();
        view.deselectHuman();
        view.deselectHumble();
    }

    private void selectOnlyHumble() {
        selectOnlyInvincible();
    }

    private void selectOnlyHuman() {
        view.selectHuman();
        view.deselectHumble();
        view.deselectInvincible();
    }

    private void selectOnlyInvincible() {
        view.selectHumble();
        view.deselectHuman();
        view.deselectInvincible();
    }

}
