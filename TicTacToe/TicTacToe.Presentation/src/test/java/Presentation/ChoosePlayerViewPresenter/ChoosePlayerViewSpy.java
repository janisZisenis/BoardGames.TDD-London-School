package Presentation.ChoosePlayerViewPresenter;

public class ChoosePlayerViewSpy implements ChoosePlayerView {

    private boolean didSelectHuman = false;
    private boolean didSelectHumble = false;
    private boolean didSelectInvincible = false;

    private boolean didDeselectHumble = false;
    private boolean didDeselectInvincible = false;
    private boolean didDeselectHuman = false;

    public boolean hasSelectedHuman() {
        return didSelectHuman;
    }
    public void selectHuman() {
        didSelectHuman = true;
    }

    public boolean hasSelectedHumble() {
        return didSelectHumble;
    }
    public void selectHumble() {
        didSelectHumble = true;
    }

    public boolean hasSelectedInvincible() {
        return didSelectInvincible;
    }
    public void selectInvincible() {
        didSelectInvincible = true;
    }


    public boolean hasDeselectedHumble() {
        return didDeselectHumble;
    }
    public void deselectHumble() {
        didDeselectHumble = true;
    }

    public boolean hasDeselectedInvincible() {
        return didDeselectInvincible;
    }
    public void deselectInvincible() {
        didDeselectInvincible = true;
    }

    public boolean hasDeselectedHuman() {
        return didDeselectHuman;
    }
    public void deselectHuman() {
        didDeselectHuman = true;
    }

}
