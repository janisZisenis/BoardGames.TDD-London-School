package Presentation.ConfigureViewPresenter;

import Presentation.ConfigureViewPresenter.Api.ConfigureViewDelegate;
import Utilities.Transaction.Transaction;

public class ConfigureViewPresenter implements ConfigureViewDelegate {

    private final ConfigureView view;
    private final Transaction cancelAction;
    private final Transaction startAction;

    public ConfigureViewPresenter(ConfigureView view, Transaction cancelAction, Transaction startAction) {
        this.view = view;
        this.cancelAction = cancelAction;
        this.startAction = startAction;
    }

    public void onCancelClicked() {
        cancelAction.execute();
    }

    public void onStartClicked() {
        startAction.execute();
    }

}
