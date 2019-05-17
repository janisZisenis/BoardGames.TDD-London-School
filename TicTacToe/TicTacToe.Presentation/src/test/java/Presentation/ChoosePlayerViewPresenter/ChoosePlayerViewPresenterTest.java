package Presentation.ChoosePlayerViewPresenter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChoosePlayerViewPresenterTest {

    private ChoosePlayerViewSpy view = new ChoosePlayerViewSpy();
    private ChoosePlayerViewPresenter sut = new ChoosePlayerViewPresenter(view);

    @Test
    void OnCreation_ShouldSelectHuman() {
        assertHumanWasSelected();
    }

    @Test
    void OnCreation_ShouldDeselectHumble() {
        assertHumbleWasDeselected();
    }

    @Test
    void OnCreation_ShouldDeselectInvincible() {
        assertInvincibleWasDeselected();
    }


    @Test
    void IfHumanGetsClicked_ShouldSelectHuman() {
        sut.onHumanClicked();

        assertHumanWasSelected();
    }

    @Test
    void IfHumanGetsClicked_ShouldDeselectHumble() {
        sut.onHumanClicked();

        assertHumbleWasDeselected();
    }

    @Test
    void IfHumanGetsClicked_ShouldDeselectInvincible() {
        sut.onHumanClicked();

        assertInvincibleWasDeselected();
    }


    @Test
    void IfHumbleGetsClicked_ShouldSelectHumble() {
        sut.onHumbleClicked();

        assertHumbleWasSelected();
    }

    @Test
    void IfHumbleGetsClicked_ShouldDeselectHuman() {
        sut.onHumbleClicked();

        assertHumanWasDeselected();
    }

    @Test
    void IfHumbleGetsClicked_ShouldDeselectInvincible() {
        sut.onHumbleClicked();

        assertInvincibleWasDeselected();
    }


    @Test
    void IfInvincibleGetsClicked_ShouldSelectHumble() {
        sut.onInvincibleClicked();

        assertInvincibleWasSelected();
    }

    @Test
    void IfInvincibleGetsClicked_ShouldDeselectHuman() {
        sut.onInvincibleClicked();

        assertHumanWasDeselected();
    }

    @Test
    void IfInvincibleGetsClicked_ShouldDeselectHumble() {
        sut.onInvincibleClicked();

        assertHumbleWasDeselected();
    }


    private void assertHumanWasSelected() {
        boolean actual = view.hasSelectedHuman();
        assertTrue(actual);
    }

    private void assertHumbleWasSelected() {
        boolean actual = view.hasSelectedHumble();
        assertTrue(actual);
    }

    private void assertInvincibleWasSelected() {
        boolean actual = view.hasSelectedInvincible();
        assertTrue(actual);
    }


    private void assertHumbleWasDeselected() {
        boolean actual = view.hasDeselectedHumble();
        assertTrue(actual);
    }

    private void assertHumanWasDeselected() {
        boolean actual = view.hasDeselectedHuman();
        assertTrue(actual);
    }

    private void assertInvincibleWasDeselected() {
        boolean actual = view.hasDeselectedInvincible();
        assertTrue(actual);
    }

}
