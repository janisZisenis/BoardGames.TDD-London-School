package Presentation.ChoosePlayerViewPresenter;

public class ChoosePlayerViewSpy extends ChoosePlayerViewDummy {

    private PlayerType selectedPlayerType;

    public PlayerType getSelectedPlayerType() {
        return selectedPlayerType;
    }
    public void setSelectedPlayerType(PlayerType type) {
        this.selectedPlayerType = type;
    }
    
}
