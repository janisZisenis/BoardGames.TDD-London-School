package MultiTurn;

import DelegatingGame.TurnSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneAdditionalTurnsAdded {

    private TurnSpy first = new TurnSpy();
    private TurnSpy second = new TurnSpy();
    private MultiTurn sut = new MultiTurn(first);

    @BeforeEach
    void Setup() {
        sut.add(second);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstOnce() {
        sut.play();
        sut.play();

        int actual = first.getPlayedTimes();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheSecondOnce() {
        sut.play();
        sut.play();

        int actual = second.getPlayedTimes();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void IfGetsPlayedFourTimes_ShouldHavePlayedTheSecondTwice() {
        sut.play();
        sut.play();
        sut.play();
        sut.play();

        int actual = second.getPlayedTimes();
        int expected = 2;
        assertEquals(expected, actual);
    }

}
