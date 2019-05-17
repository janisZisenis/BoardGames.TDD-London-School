package Presentation.ChoosePlayerViewPresenter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ProvidingDistinctPlayerTypeTest {

    private ChoosePlayerViewSpy view = new ChoosePlayerViewSpy();
    private ChoosePlayerViewPresenter sut = new ChoosePlayerViewPresenter(view);

    @Test
    void IfNoSelectionIsMade_ShouldNotHaveADistinctPlayerType() {
        assertHasNoDistinctPlayerType();
    }

    @Test
    void IfNoSelectionIsMade_GettingThePlayerTypeShouldThrow() {
        Executable act = () -> sut.getDistinctPlayerType();

        assertThrows(ChoosePlayerViewPresenter.NoDistinctPlayerType.class, act);
    }


    @Test
    void IfOnlyHumanIsSelected_ShouldHaveADistinctPlayerType() {
        makeOnlyHumanIsSelected();

        assertHasDistinctPlayerType();
    }

    @Test
    void IfOnlyHumanIsSelected_PlayerTypeShouldBeHuman() {
        makeOnlyHumanIsSelected();

        PlayerType actual = sut.getDistinctPlayerType();

        PlayerType expected = PlayerType.Human;
        assertEquals(expected, actual);
    }


    @Test
    void IfOnlyHumbleIsSelected_ShouldHaveADistinctPlayerType() {
        makeOnlyHumbleIsSelected();

        assertHasDistinctPlayerType();
    }

    @Test
    void IfOnlyHumbleIsSelected_PlayerTypeShouldBeHuman() {
        makeOnlyHumbleIsSelected();

        PlayerType actual = sut.getDistinctPlayerType();

        PlayerType expected = PlayerType.Humble;
        assertEquals(expected, actual);
    }


    @Test
    void IfOnlyInvincibleIsSelected_ShouldHaveADistinctPlayerType() {
        makeOnlyInvincibleIsSelected();

        assertHasDistinctPlayerType();
    }

    @Test
    void IfOnlyInvincibleIsSelected_PlayerTypeShouldBeHuman() {
        makeOnlyInvincibleIsSelected();

        PlayerType actual = sut.getDistinctPlayerType();

        PlayerType expected = PlayerType.Invincible;
        assertEquals(expected, actual);
    }


    @Test
    void IfAllAreSelected_ShouldNotHaveADistinctPlayerType() {
        makeAllAreSelected();

        assertHasNoDistinctPlayerType();
    }

    @Test
    void IfAllAreSelected_GettingThePlayerTypeShouldThrow() {
        makeAllAreSelected();

        Executable act = () -> sut.getDistinctPlayerType();

        assertThrows(ChoosePlayerViewPresenter.NoDistinctPlayerType.class, act);
    }



    @Test
    void IfHumanAndHumbleAreSelected_ShouldNotHaveADistinctPlayerType() {
        makeHumanAndHumbleAreSelected();

        assertHasNoDistinctPlayerType();
    }

    @Test
    void IfHumanAndHumbleAreSelected_GettingThePlayerTypeShouldThrow() {
        makeHumanAndHumbleAreSelected();

        Executable act = () -> sut.getDistinctPlayerType();

        assertThrows(ChoosePlayerViewPresenter.NoDistinctPlayerType.class, act);
    }


    @Test
    void IfHumanAndInvincibleAreSelected_ShouldNotHaveADistinctPlayerType() {
        makeHumanAndInvincibleAreSelected();

        assertHasNoDistinctPlayerType();
    }

    @Test
    void IfHumanAndInvincibleAreSelected_GettingThePlayerTypeShouldThrow() {
        makeHumanAndInvincibleAreSelected();

        Executable act = () -> sut.getDistinctPlayerType();

        assertThrows(ChoosePlayerViewPresenter.NoDistinctPlayerType.class, act);
    }

    @Test
    void IfHumbleAndInvincibleAreSelected_ShouldNotHaveADistinctPlayerType() {
        makeHumbleAndInvincibleAreSelected();

        assertHasNoDistinctPlayerType();
    }

    @Test
    void IfHumbleAndInvincibleAreSelected_GettingThePlayerTypeShouldThrow() {
        makeHumbleAndInvincibleAreSelected();

        Executable act = () -> sut.getDistinctPlayerType();

        assertThrows(ChoosePlayerViewPresenter.NoDistinctPlayerType.class, act);
    }


    private void makeHumbleAndInvincibleAreSelected() {
        view.setHumanIsSelected(false);
        view.setHumbleIsSelected(true);
        view.setInvincibleIsSelected(true);
    }

    private void makeHumanAndInvincibleAreSelected() {
        view.setHumanIsSelected(true);
        view.setHumbleIsSelected(false);
        view.setInvincibleIsSelected(true);
    }

    private void makeHumanAndHumbleAreSelected() {
        view.setHumanIsSelected(true);
        view.setHumbleIsSelected(true);
        view.setInvincibleIsSelected(false);
    }

    private void makeOnlyInvincibleIsSelected() {
        view.setHumanIsSelected(false);
        view.setHumbleIsSelected(false);
        view.setInvincibleIsSelected(true);
    }

    private void makeOnlyHumbleIsSelected() {
        view.setHumanIsSelected(false);
        view.setHumbleIsSelected(true);
        view.setInvincibleIsSelected(false);
    }

    private void makeOnlyHumanIsSelected() {
        view.setHumanIsSelected(true);
        view.setHumbleIsSelected(false);
        view.setInvincibleIsSelected(false);
    }

    private void makeAllAreSelected() {
        view.setHumanIsSelected(true);
        view.setHumbleIsSelected(true);
        view.setInvincibleIsSelected(true);
    }


    private void assertHasDistinctPlayerType() {
        boolean actual = sut.hasDistinctPlayerType();
        assertTrue(actual);
    }

    private void assertHasNoDistinctPlayerType() {
        boolean actual = sut.hasDistinctPlayerType();
        assertFalse(actual);
    }

}
