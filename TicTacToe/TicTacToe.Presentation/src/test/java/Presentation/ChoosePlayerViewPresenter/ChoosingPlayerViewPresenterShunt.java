package Presentation.ChoosePlayerViewPresenter;

import Utilities.Observer.Observer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChoosingPlayerViewPresenterShunt extends ChoosePlayerViewDummy implements Observer {

    private String logString = "";

    private ChoosePlayerViewPresenter sut = new ChoosePlayerViewPresenter(this);

    @Test
    void IfHumanGetsClicked_ShouldFirstSelectHumanBeforeUpdating() {
        sut.attach(this);
        logString = "";

        sut.onHumanClicked();

        assertLogStringEquals("setSelectedPlayerType update ");
    }

    private void assertLogStringEquals(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public void update() {
        logString += "update ";
    }

    public void setSelectedPlayerType(PlayerType type) {
        logString += "setSelectedPlayerType ";
    }

}
