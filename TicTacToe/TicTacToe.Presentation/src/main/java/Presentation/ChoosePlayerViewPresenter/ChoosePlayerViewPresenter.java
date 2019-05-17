package Presentation.ChoosePlayerViewPresenter;

public class ChoosePlayerViewPresenter {

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

    public void onInvincibleClicked() {
        view.selectInvincible();
        view.deselectHuman();
        view.deselectHumble();
    }
}
