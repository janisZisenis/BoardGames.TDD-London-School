package InteractiveGaming.MultiHybridPlayer;

import InteractiveGaming.HybridGameImp.HybridPlayerSpy;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoAdditionalHybridPlayersAdded {

    private HybridPlayerSpy first = new HybridPlayerSpy();
    private MultiHybridPlayer sut = new MultiHybridPlayer(first);

    private HybridPlayerSpy second = new HybridPlayerSpy();
    private HybridPlayerSpy third = new HybridPlayerSpy();

    @BeforeEach
    void SetUp() {
        sut.add(second);
        sut.add(third);
    }


    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheSecondOnce() {
        sut.play();
        sut.play();


        assertPlayedTimes(second, 1);
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheThirdOnce() {
        sut.play();
        sut.play();
        sut.play();

        assertPlayedTimes(third, 1);
    }

    private void assertPlayedTimes(HybridPlayerSpy p, int expected) {
        int actual = p.getTimesPlayedWithoutInput();
        assertEquals(expected, actual);
    }


    @Test
    void IfGetsPlayedWithInputR0C0Twice_ShouldPlayInputR0C0OnSecond() {
        Input input = new Input(0, 0);

        sut.playInput(input);
        sut.playInput(input);

        assertPlayedInputEquals(second, new Input(0, 0));
    }


    @Test
    void IfGetsPlayedOnceThenResetThenPlayedOnce_FirstShouldHavePlayedTwice() {
        sut.play();
        sut.reset();

        sut.play();

        assertPlayedTimes(first, 2);
    }


    private void assertPlayedInputEquals(HybridPlayerSpy p, Input expected) {
        Input actual = p.getPlayedInput();
        assertEquals(expected, actual);
    }

}
