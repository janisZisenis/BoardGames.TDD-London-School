package GuiGaming.HybridGameLoopImp;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HybridGameLoopImpTest {

    private HybridGameSpy game = new HybridGameSpy();
    private HybridGameLoopImp sut = new HybridGameLoopImp(game);

    @Test
    void IfGameIsPlayableOnce_ShouldPlayOnce() {
        game.setTimesPlayable(1);

        sut.playComputerTurns();

        assertHasPlayedTimes(1);
    }

    @Test
    void IfGameIsPlayableTwice_ShouldPlayTwice() {
        game.setTimesPlayable(2);

        sut.playComputerTurns();

        assertHasPlayedTimes(2);
    }

    private void assertHasPlayedTimes(int expected) {
        int actual = game.getPlayedTimes();
        assertEquals(expected, actual);
    }


    @Test
    void IfGameNeedsInput_ShouldNeedInputEither() {
        game.setTimesNeedsInput(1);

        assertNeedsInput();
    }

    @Test
    void IfGameDoesNotNeedInput_ShouldNotNeedInputEither() {
        game.setTimesNeedsInput(0);

        assertDoesNotNeedInput();
    }

    private void assertDoesNotNeedInput() {
        boolean actual = sut.nextIsHuman();
        assertFalse(actual);
    }

    private void assertNeedsInput() {
        boolean actual = sut.nextIsHuman();
        assertTrue(actual);
    }


    @Test
    void IfNeedsInputAndInputIsR0C0_ShouldPlayInputR0C0() {
        game.setTimesNeedsInput(1);
        Input input = new Input(0, 0);

        sut.playHuman(input);

        assertRunInputEquals(new Input(0, 0));
    }

    @Test
    void IfNeedsInputAndInputIsR1C2_ShouldRunInputR1C2() {
        game.setTimesNeedsInput(1);
        Input input = new Input(1, 2);

        sut.playHuman(input);

        assertRunInputEquals(new Input(1, 2));
    }

    private void assertRunInputEquals(Input input) {
        Input actual = game.getPlayedInput();
        Input expected = input;
        assertEquals(expected, actual);
    }


}
