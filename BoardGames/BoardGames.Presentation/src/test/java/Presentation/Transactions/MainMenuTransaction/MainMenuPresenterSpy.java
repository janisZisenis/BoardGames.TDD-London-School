package Presentation.Transactions.MainMenuTransaction;

public class MainMenuPresenterSpy implements MainMenuPresenter {

    private boolean didShowMainMenu = false;

    public boolean hasShownMainMenu() {
        return didShowMainMenu;
    }
    public void showMainMenu() {
        didShowMainMenu = true;
    }

}
