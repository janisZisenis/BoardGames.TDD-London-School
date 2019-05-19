package Presentation.ConfigureViewPresenter;

import Presentation.ConfigureViewPresenter.Api.ConfigureViewDelegate;
import Utilities.Transaction.Transaction;

public class ConfigureViewPresenter implements ConfigureViewDelegate {

    private final ConfigureView view;
    private final Transaction cancelAction;
    private final RunInteractor interactor;

    public ConfigureViewPresenter(ConfigureView view, Transaction cancelAction, RunInteractor interactor) {
        this.view = view;
        this.cancelAction = cancelAction;
        this.interactor = interactor;
    }

    public void onCancelClicked() {
        cancelAction.execute();
    }

    public void onStartClicked() {
        PlayerType first = view.getFirstPlayerType();
        PlayerType second = view.getSecondPlayerType();

        RunRequest request = new RunRequest(first, second);
        interactor.sendRun(request);
    }

}
