package InteractiveGaming.MultiHybridPlayer;

import InteractiveGaming.HybridGameImp.HybridPlayerSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneAdditionalHybridPlayerAdded {

    private HybridPlayerSpy first = new HybridPlayerSpy();
    private MultiHybridPlayer sut = new MultiHybridPlayer(first);

    private HybridPlayerSpy second = new HybridPlayerSpy();

    @BeforeEach
    void SetUp() {
        sut.add(second);
    }


    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstOnce() {
        sut.play();
        sut.play();

        assertPlayedTimes(first, 1);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheSecondOnce() {
        sut.play();
        sut.play();

        assertPlayedTimes(second, 1);
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheFirstTwice() {
        sut.play();
        sut.play();
        sut.play();

        assertPlayedTimes(first, 2);
    }

    private void assertPlayedTimes(HybridPlayerSpy p, int expected) {
        int actual = p.getTimesPlayedWithoutInput();
        assertEquals(expected, actual);
    }

}
