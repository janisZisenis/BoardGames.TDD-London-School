package Presentation.ChoosePlayerViewPresenter;

public class ChoosePlayerViewDummy implements ChoosePlayerView {
    public void selectHuman() {}
    public void selectHumble() {}
    public void selectInvincible() {}

    public void deselectHumble() {}
    public void deselectInvincible() {}
    public void deselectHuman() {}

    public boolean isHumanSelected() {
        return false;
    }
    public boolean isHumbleSelected() {
        return false;
    }
    public boolean isInvincibleSelected() {
        return false;
    }
}
