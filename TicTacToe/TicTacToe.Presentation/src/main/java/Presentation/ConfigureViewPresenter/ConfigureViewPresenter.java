package Presentation.ConfigureViewPresenter;

public class ConfigureViewPresenter {

    private final ConfigureView view;
    private final PlayerTypeProvider provider;

    public ConfigureViewPresenter(ConfigureView view, PlayerTypeProvider provider) {
        this.view = view;
        this.provider = provider;
    }

    public void update() {
        if(provider.hasDistinctPlayerType())
            view.enableStartButton();
        else
            view.disableStartButton();
    }
}
