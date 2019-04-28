package Lib.Model.TwoPlayerTurn.MessagingTwoPlayerTurn;

import Lib.Model.TwoPlayerTurn.PlayerSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VerboseAlternatePlayingTest {

    private PlayerSpy first = new PlayerSpy();
    private PlayerSpy second = new PlayerSpy();
    private TurnMessengerDummy view = new TurnMessengerDummy();
    private MessagingTwoPlayerTurn sut = new MessagingTwoPlayerTurn(first, second, view);

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
