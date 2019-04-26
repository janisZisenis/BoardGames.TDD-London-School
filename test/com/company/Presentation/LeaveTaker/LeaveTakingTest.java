package com.company.Presentation.LeaveTaker;

import com.company.Data.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeaveTakingTest {

    private WinnerProviderStub provider = new WinnerProviderStub();
    private LeaveTakerViewSpy view = new LeaveTakerViewSpy();
    private LeaveTaker sut = new LeaveTaker(provider, view);

    @Test
    void IfNoWinnerIsProvided_ShouldShowDraw() {
        sut.showLeaveTaking();

        assertHasShownDraw();
    }

    @Test
    void IfWinnerIsProvided_ShouldNotShowDraw() {
        provider.setWinner(Mark.John);

        sut.showLeaveTaking();

        assertHasNotShownDraw();
    }

    @Test
    void IfJohnIsProvidedAsWinner_ShouldShowJohnAsWinner() {
        provider.setWinner(Mark.John);

        sut.showLeaveTaking();

        assertShownWinnerIs(Mark.John);
    }

    @Test
    void IfHaleyIsProvidedAsWinner_ShouldShowHaleyAsWinner() {
        provider.setWinner(Mark.Haley);

        sut.showLeaveTaking();

        assertShownWinnerIs(Mark.Haley);
    }

    @Test
    void IfNoWinnerIsProvided_ShouldNotShowAWinner() {
        sut.showLeaveTaking();

        assertHasNotShownAWinner();
    }

    private void assertHasShownDraw() {
        boolean actual = view.hasShownDraw();
        assertTrue(actual);
    }

    private void assertHasNotShownDraw() {
        boolean actual = view.hasShownDraw();
        assertFalse(actual);
    }

    private void assertShownWinnerIs(Mark expected) {
        Mark actual = view.getShownWinner();
        assertEquals(expected, actual);
    }

    private void assertHasNotShownAWinner() {
        boolean actual = view.hasShownWinner();
        assertFalse(actual);
    }

}
