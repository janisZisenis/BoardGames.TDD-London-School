package Presentation.ChoosePlayerViewPresenter;

import Domain.Board.BoardDecorators.ObservableBoard.Observer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChoosingPlayerViewPresenterShunt implements ChoosePlayerView, Observer {

    private String logString = "";

    @Test
    void IfHumanGetsClicked_ShouldFirstSelectHumanBeforeUpdating() {
        ChoosePlayerViewPresenter sut = new ChoosePlayerViewPresenter(this);
        sut.attach(this);
        logString = "";

        sut.onHumanClicked();

        assertLogStringEquals("selectHuman update ");
    }

    @Test
    void IfHumbleGetsClicked_ShouldFirstSelectHumbleBeforeUpdating() {
        ChoosePlayerViewPresenter sut = new ChoosePlayerViewPresenter(this);
        sut.attach(this);
        logString = "";

        sut.onHumbleClicked();

        assertLogStringEquals("selectHumble update ");
    }

    @Test
    void IfInvincibleGetsClicked_ShouldFirstSelectInvincibleBeforeUpdating() {
        ChoosePlayerViewPresenter sut = new ChoosePlayerViewPresenter(this);
        sut.attach(this);
        logString = "";

        sut.onInvincibleClicked();

        assertLogStringEquals("selectInvincible update ");
    }

    private void assertLogStringEquals(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public void update() {
        logString += "update ";
    }

    public void selectHuman() {
        logString += "selectHuman ";
    }
    public void selectHumble() {
        logString += "selectHumble ";
    }
    public void selectInvincible() {
        logString += "selectInvincible ";
    }

    public void deselectHumble() {

    }
    public void deselectInvincible() {

    }
    public void deselectHuman() {

    }

    public boolean isHumanSelected() {
        return false;
    }
    public boolean isHumbleSelected() {
        return false;
    }
    public boolean isInvincibleSelected() {
        return false;
    }
}
