package HybridGaming.MultiHybridPlayer;

import HybridGaming.HybridGameImp.HybridPlayerSpy;
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
        sut.playComputer();
        sut.playComputer();


        assertPlayedTimes(second, 1);
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheThirdOnce() {
        sut.playComputer();
        sut.playComputer();
        sut.playComputer();

        assertPlayedTimes(third, 1);
    }

    private void assertPlayedTimes(HybridPlayerSpy p, int expected) {
        int actual = p.getTimesPlayedComputer();
        assertEquals(expected, actual);
    }


    @Test
    void IfGetsPlayedWithInputR0C0Twice_ShouldPlayInputR0C0OnSecond() {
        Input input = new Input(0, 0);

        sut.playHuman(input);
        sut.playHuman(input);

        assertPlayedInputEquals(second, new Input(0, 0));
    }

    private void assertPlayedInputEquals(HybridPlayerSpy p, Input expected) {
        Input actual = p.getPlayedInput();
        assertEquals(expected, actual);
    }

}
