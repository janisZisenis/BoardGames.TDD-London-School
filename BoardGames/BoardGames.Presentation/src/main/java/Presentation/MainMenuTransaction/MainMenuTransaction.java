package Presentation.MainMenuTransaction;

import Presentation.ShellPresenter.Api.MainMenuPresenter;
import Utilities.Transaction.Transaction;

public class MainMenuTransaction implements Transaction {

    private final MainMenuPresenter presenter;

    public MainMenuTransaction(MainMenuPresenter presenter) {
        this.presenter = presenter;
    }

    public void execute() {
        presenter.showMainMenu();
    }

}
