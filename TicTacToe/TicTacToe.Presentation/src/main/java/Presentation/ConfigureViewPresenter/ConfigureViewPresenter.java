package Presentation.ConfigureViewPresenter;

import Utilities.Observer.Observer;
import Presentation.ConfigureViewPresenter.Api.ConfigureViewDelegate;
import Presentation.ShellPresenter.Api.MainMenuPresenter;

public class ConfigureViewPresenter implements ConfigureViewDelegate, Observer {

    private final ConfigureView view;
    private final IsStartableProvider provider;
    private final MainMenuPresenter presenter;

    public ConfigureViewPresenter(ConfigureView view, IsStartableProvider provider, MainMenuPresenter presenter) {
        this.view = view;
        this.provider = provider;
        this.presenter = presenter;
    }

    public void update() {
        if(provider.isStartable())
            view.enableStartButton();
        else
            view.disableStartButton();
    }

    public void onCancelClicked() {
        presenter.showMainMenu();
    }

    public void onStartClicked() {
        int i = 0;
    }

}
