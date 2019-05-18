package Presentation.ChoosePlayerViewPresenter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChoosePlayerViewPresenterTest {

    private ChoosePlayerViewSpy view = new ChoosePlayerViewSpy();
    private ChoosePlayerViewPresenter sut = new ChoosePlayerViewPresenter(view);

    @Test
    void OnCreation_ShouldSetHumanSelected() {
        assertSelectedPlayerTypeEquals(PlayerType.Human);
    }

    @Test
    void IfHumanGetsClicked_ShouldSelectHuman() {
        sut.onHumanClicked();

        assertSelectedPlayerTypeEquals(PlayerType.Human);
    }


    @Test
    void IfHumbleCPUGetsClicked_ShouldSelectHumble() {
        sut.onHumbleCPUClicked();

        assertSelectedPlayerTypeEquals(PlayerType.HumbleCPU);
    }


    @Test
    void IfInvincibleCPUGetsClicked_ShouldSelectInvincibleCPU() {
        sut.onInvincibleCPUClicked();

        assertSelectedPlayerTypeEquals(PlayerType.InvincibleCPU);
    }


    private void assertSelectedPlayerTypeEquals(PlayerType expected) {
        PlayerType actual = view.getSelectedPlayerType();
        assertEquals(expected, actual);
    }

}
