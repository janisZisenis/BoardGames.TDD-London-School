package FXBoardGames.notTested_Demo;

import Presentation.ChoosePlayerViewPresenter.ChoosePlayerViewPresenter;
import Presentation.ConfigureViewPresenter.IsStartableProvider;

public class PlayersChosenStartableProvider implements IsStartableProvider {

    private final ChoosePlayerViewPresenter first;
    private final ChoosePlayerViewPresenter second;

    public PlayersChosenStartableProvider(ChoosePlayerViewPresenter first, ChoosePlayerViewPresenter second) {
        this.first = first;
        this.second = second;
    }

    public boolean isStartable() {
        return first.hasDistinctPlayerType() && second.hasDistinctPlayerType();
    }
}
