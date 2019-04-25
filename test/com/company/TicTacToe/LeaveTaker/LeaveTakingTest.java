package com.company.TicTacToe.LeaveTaker;

import com.company.TicTacToe.Board.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeaveTakingTest {

    private WinnerProviderStub provider = new WinnerProviderStub();
    private LeaveTakerViewSpy view = new LeaveTakerViewSpy();
    private LeaveTaker sut = new LeaveTaker(provider, view);

    @Test
    void IfNoWinnerIsProvided_ShouldShowDraw() {
        sut.showLeaveTaking();

        assertShowedDraw();
    }

    @Test
    void IfWinnerIsProvided_ShouldNotHaveShowedDraw() {
        provider.setWinner(Mark.John);

        sut.showLeaveTaking();

        assertHasNotShowedDraw();
    }

    @Test
    void IfJohnIsProvidedAsWinner_ShouldShowJohnAsWinner() {
        provider.setWinner(Mark.John);

        sut.showLeaveTaking();

        assertShowedWinner(Mark.John);
    }

    @Test
    void IfHaleyIsProvidedAsWinner_ShouldShowHaleyAsWinner() {
        provider.setWinner(Mark.Haley);

        sut.showLeaveTaking();

        assertShowedWinner(Mark.Haley);
    }

    @Test
    void IfNoWinnerIsProvided_ShouldNotHaveShowedAWinner() {
        sut.showLeaveTaking();

        assertHasNotShowedAWinner();
    }

    private void assertShowedDraw() {
        boolean actual = view.showedDraw();
        assertTrue(actual);
    }

    private void assertHasNotShowedDraw() {
        boolean actual = view.showedDraw();
        assertFalse(actual);
    }

    private void assertShowedWinner(Mark expected) {
        Mark actual = view.getShowedWinner();
        assertEquals(expected, actual);
    }

    private void assertHasNotShowedAWinner() {
        boolean actual = view.hasShowedWinner();
        assertFalse(actual);
    }

}
