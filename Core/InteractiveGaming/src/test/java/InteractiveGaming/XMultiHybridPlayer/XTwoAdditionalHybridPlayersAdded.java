package InteractiveGaming.XMultiHybridPlayer;

import Input2D.Input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XTwoAdditionalHybridPlayersAdded {

    private XHybridPlayerSpy first = new XHybridPlayerSpy();
    private XMultiHybridPlayer sut = new XMultiHybridPlayer(first);

    private XHybridPlayerSpy second = new XHybridPlayerSpy();
    private XHybridPlayerSpy third = new XHybridPlayerSpy();

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

    private void assertPlayedTimes(XHybridPlayerSpy p, int expected) {
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


    private void assertPlayedInputEquals(XHybridPlayerSpy p, Input expected) {
        Input actual = p.getPlayedInput();
        assertEquals(expected, actual);
    }

}
