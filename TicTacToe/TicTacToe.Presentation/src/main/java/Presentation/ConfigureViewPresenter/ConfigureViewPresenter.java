package Presentation.ConfigureViewPresenter;

import Presentation.ConfigureViewPresenter.Api.ConfigureViewDelegate;
import Utilities.Observer.Observer;
import Utilities.Transaction.Transaction;

public class ConfigureViewPresenter implements ConfigureViewDelegate, Observer {

    private final ConfigureView view;
    private final IsStartableProvider provider;
    private final Transaction cancelAction;
    private final Transaction startAction;

    public ConfigureViewPresenter(ConfigureView view, IsStartableProvider provider,
                                  Transaction cancelAction,
                                  Transaction startAction) {
        this.view = view;
        this.provider = provider;
        this.cancelAction = cancelAction;
        this.startAction = startAction;
    }

    public void update() {
        if(provider.isStartable())
            view.enableStartButton();
        else
            view.disableStartButton();
    }

    public void onViewDidShow() {
        update();
    }

    public void onCancelClicked() {
        cancelAction.execute();
    }

    public void onStartClicked() {
        startAction.execute();
    }

}
