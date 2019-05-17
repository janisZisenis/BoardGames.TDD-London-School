package Presentation.ShellPresenter.Api;

import Presentation.ShellPresenter.Api.MainMenuPresenter;

public class MainMenuPresenterSpy implements MainMenuPresenter {

    private boolean didShowMainMenu = false;

    public boolean hasShownMainMenu() {
        return didShowMainMenu;
    }
    public void showMainMenu() {
        didShowMainMenu = true;
    }

}
