package com.company.Core.GameLoop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameLoopTest {

    private CountingGameOverRuleStub rule = new CountingGameOverRuleStub();
    private TurnSpy turn = new TurnSpy();
    private GameLoop sut = new GameLoop(turn, rule);

    @Test
    void IfGameIsOverAfterOneTurn_TheShouldHavePlayedOnce() {
        rule.setTimesNotGameOver(1);

        sut.play();

        assertTurnHasPlayedTimes(1);
    }

    @Test
    void IfGameIsOverImmediately_TheTurnShouldNotHavePlayed() {
        rule.setTimesNotGameOver(0);

        sut.play();

        assertTurnHasPlayedTimes(0);
    }

    @Test
    void IfGameIsOverAfterTwoTurns_TheShouldHavePlayedTwice() {
        rule.setTimesNotGameOver(2);

        sut.play();

        assertTurnHasPlayedTimes(2);
    }

    @Test
    void IfGameIsOverAfterThreeTurns_TheShouldHavePlayedThreeTimes() {
        rule.setTimesNotGameOver(3);

        sut.play();

        assertTurnHasPlayedTimes(3);
    }

    private void assertTurnHasPlayedTimes(int i) {
        int actual = turn.getPlayedTimes();
        int expected = i;
        assertEquals(expected, actual);
    }
}
