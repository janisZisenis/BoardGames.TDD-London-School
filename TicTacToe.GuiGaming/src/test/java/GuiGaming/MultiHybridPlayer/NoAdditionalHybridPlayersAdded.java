package GuiGaming.MultiHybridPlayer;

import GuiGaming.HybridGameFacade.HybridPlayerSpy;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoAdditionalHybridPlayersAdded {

    private HybridPlayerSpy first = new HybridPlayerSpy();
    private MultiHybridPlayer sut = new MultiHybridPlayer(first);

    @Test
    void IfGetsPlayedOnce_ShouldHavePlayedTheFirstOnce() {
        sut.play();

        assertPlayedTimes(1);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstTwice() {
        sut.play();
        sut.play();

        assertPlayedTimes(2);
    }

    @Test
    void IfGetsPlayedFourTimes_ShouldHavePlayedTheFirstFourTimes() {
        sut.play();
        sut.play();
        sut.play();
        sut.play();

        assertPlayedTimes(4);
    }

    private void assertPlayedTimes(int expected) {
        int actual = first.getPlayedTimes();
        assertEquals(expected, actual);
    }


    @Test
    void IfInputR0C0GetsPlayed_ShouldPlayInputR0C0Either() {
        Input input = new Input(0, 0);

        sut.play(input);

        assertPlayedInputEquals(new Input(0, 0));
    }

    @Test
    void IfInputR1C2GetsPlayed_ShouldPlayInputR1C2Either() {
        Input input = new Input(1, 2);

        sut.play(input);

        assertPlayedInputEquals(new Input(1, 2));
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = first.getPlayedInput();
        assertEquals(expected, actual);
    }


    @Test
    void IfFirstNeedsInput_ShouldNeedInputEither() {
        first.setNeedsInput(true);

        assertNeedsInput();
    }

    private void assertNeedsInput() {
        boolean actual = sut.needsInput();
        assertTrue(actual);
    }


    @Test
    void IfFirstDoesNotNeedInput_ShouldNotNeedInputEither() {
        first.setNeedsInput(false);

        assertDoesNotNeedInput();
    }

    private void assertDoesNotNeedInput() {
        boolean actual = sut.needsInput();
        assertFalse(actual);
    }

}
