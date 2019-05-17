package Presentation.ConfigureViewPresenter;

import Domain.Board.BoardDecorators.ObservableBoard.Observer;
import Presentation.ConfigureViewPresenter.Api.ConfigureViewDelegate;
import Presentation.ShellPresenter.Api.MainMenuPresenter;

public class ConfigureViewPresenter implements ConfigureViewDelegate, Observer {

    private final ConfigureView view;
    private final PlayerTypeProvider provider;
    private final MainMenuPresenter presenter;

    public ConfigureViewPresenter(ConfigureView view, PlayerTypeProvider provider, MainMenuPresenter presenter) {
        this.view = view;
        this.provider = provider;
        this.presenter = presenter;
    }

    public void update() {
        if(provider.hasPlayerTypes())
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
