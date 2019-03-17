package com.company.Core.GameLoop.TwoPlayerTurn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TwoPlayerTurnTest {

    private PlayerSpy first = new PlayerSpy();
    private PlayerSpy second = new PlayerSpy();
    private TwoPlayerTurn sut = new TwoPlayerTurn(first, second);

    @Test
    void IfGamePlaysOnce_FirstPlayerShouldHavePlayedMoveOnce() {
        sut.play();

        assertPlayerHasPlayedTimes(first, 1);
    }

    @Test
    void IfGamePlaysTwice_SecondPlayerShouldHavePlayedMoveOnce() {
        playTwice();

        assertPlayerHasPlayedTimes(second, 1);
    }

    @Test
    void IfGamePlaysTwice_FirstPlayerShouldHavePlayedMoveOnce() {
        playTwice();

        assertPlayerHasPlayedTimes(first, 1);
    }

    @Test
    void IfGamePlaysThreeTimes_FirstPlayerShouldHavePlayedMoveTwice() {
        playThreeTimes();

        assertPlayerHasPlayedTimes(first, 2);
    }

    @Test
    void IfGamePlaysFourTimes_SecondPlayerShouldHavePlayedMoveTwice() {
        playFourTimes();

        assertPlayerHasPlayedTimes(second, 2);
    }

    private void playTwice() {
        sut.play();
        sut.play();
    }

    private void playThreeTimes() {
        playTwice();

        sut.play();
    }

    private void playFourTimes() {
        playThreeTimes();
        sut.play();
    }

    private void assertPlayerHasPlayedTimes(PlayerSpy second, int times) {
        int actual = second.getPlayedMoveCount();
        int expected = times;
        assertEquals(expected, actual);
    }
}
