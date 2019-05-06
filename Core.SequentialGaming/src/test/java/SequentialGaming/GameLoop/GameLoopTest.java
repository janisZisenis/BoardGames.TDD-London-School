package SequentialGaming.GameLoop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLoopTest {

    private GameSpy game = new GameSpy();
    private GameLoop sut = new GameLoop(game);


    @Test
    void IfGameIsOverImmediately_ShouldNotHavePlayed() {
        game.setTimesItsNotOver(0);

        sut.run();

        assertTimesPlayed(0);
    }

    @Test
    void IfGameIsOverImmediately_ShouldNotHaveRendered() {
        game.setTimesItsNotOver(0);

        sut.run();

        assertTimesRendered(0);
    }

    @Test
    void IfGameIsOnceNotOver_ShouldHavePlayedOnce() {
        game.setTimesItsNotOver(1);

        sut.run();

        assertTimesPlayed(1);
    }

    @Test
    void IfGameIsOnceNotOver_ShouldHaveRenderedOnce() {
        game.setTimesItsNotOver(1);

        sut.run();

        assertTimesRendered(1);
    }


    @Test
    void IfGameIsTwiceNotOver_ShouldHavePlayedTwice() {
        game.setTimesItsNotOver(2);

        sut.run();

        assertTimesPlayed(2);
    }

    @Test
    void IfGameIsTwiceNotOver_ShouldHaveRenderedTwice() {
        game.setTimesItsNotOver(2);

        sut.run();

        assertTimesRendered(2);
    }

    private void assertTimesPlayed(int expected) {
        int actual = game.getTimesPlayed();
        assertEquals(expected, actual);
    }

    private void assertTimesRendered(int expected) {
        int actual = game.getTimesRendered();
        assertEquals(expected, actual);
    }

}
