package InteractiveGaming.MultiHybridPlayer;

import Input2D.Input.Input;
import InteractiveGaming.HybridGameImp.HybridPlayerSpy;
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
    void IfGetsPlayedWithInputTwice_ShouldPlayInputOnSecond() {
        Input input = new Input(0, 0);

        sut.playInput(input);
        sut.playInput(input);

        assertPlayedInputEquals(second, input);
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
