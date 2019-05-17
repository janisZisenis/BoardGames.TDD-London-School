package Presentation.ConfigureViewPresenter;

public class ConfigureViewSpy implements ConfigureView {

    private boolean didDisableStartButton = false;
    private boolean didEnableStartButton = false;

    public boolean hasDisabledStartButton() {
        return didDisableStartButton;
    }
    public void disableStartButton() {
        didDisableStartButton = true;
    }

    public boolean hasEnabledStartButton() {
        return didEnableStartButton;
    }
    public void enableStartButton() {
        didEnableStartButton = true;
    }

}
