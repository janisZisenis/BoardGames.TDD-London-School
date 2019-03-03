package com.company.TicTacToe.CountingReferee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountingRefereeTest {

    CountingReferee sut = new CountingReferee();

    @Test
    void FreshInstance_ShouldHaveAMovesLeft() {
        boolean actual = sut.hasMovesLeft();

        assertTrue(actual);
    }

    @Test
    void IfItWasAskedNineTimes_TheTenthTimeShouldNotHaveMovesLeft() {
        makeNineTimesAskedForMovesLeft();

        boolean actual = sut.hasMovesLeft();

        assertFalse(actual);
    }

    @Test
    void IfItWasAskedOnce_TheSecondTimeShouldHaveMovesLeft() {
        sut.hasMovesLeft();

        boolean actual = sut.hasMovesLeft();

        assertTrue(actual);
    }

    @Test
    void IfItWasAskedTwice_TheThirdTimeShouldHaveMovesLeft() {
        makeTwiceAskedForMovesLeft();

        boolean actual = sut.hasMovesLeft();

        assertTrue(actual);
    }


    private void makeTwiceAskedForMovesLeft() {
        sut.hasMovesLeft();
        sut.hasMovesLeft();
    }

    private void makeNineTimesAskedForMovesLeft() {
        makeTwiceAskedForMovesLeft();
        sut.hasMovesLeft();

        sut.hasMovesLeft();
        sut.hasMovesLeft();
        sut.hasMovesLeft();

        sut.hasMovesLeft();
        sut.hasMovesLeft();
        sut.hasMovesLeft();
    }

}
