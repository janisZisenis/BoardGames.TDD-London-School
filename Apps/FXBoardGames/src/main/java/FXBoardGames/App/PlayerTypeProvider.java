package FXBoardGames.App;

import Presentation.ChoosePlayerViewPresenter.ChoosePlayerViewPresenter;
import Presentation.ChoosePlayerViewPresenter.PlayerType;

public class PlayerTypeProvider {

    private final ChoosePlayerViewPresenter first;
    private final ChoosePlayerViewPresenter second;

    public PlayerTypeProvider(ChoosePlayerViewPresenter first, ChoosePlayerViewPresenter second) {
        this.first = first;
        this.second = second;
    }

    public PlayerType getFirst() {
        return first.getDistinctPlayerType();
    }

    public PlayerType getSecond() {
        return second.getDistinctPlayerType();
    }


}
