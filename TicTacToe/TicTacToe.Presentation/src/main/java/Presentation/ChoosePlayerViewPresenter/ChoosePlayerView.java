package Presentation.ChoosePlayerViewPresenter;

public interface ChoosePlayerView {
    void selectHuman();
    void selectHumble();
    void selectInvincible();

    void deselectHumble();
    void deselectInvincible();
    void deselectHuman();

    boolean isHumanSelected();
    boolean isHumbleSelected();
    boolean isInvincibleSelected();
}
