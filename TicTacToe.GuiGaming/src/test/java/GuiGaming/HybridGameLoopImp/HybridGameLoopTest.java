package GuiGaming.HybridGameLoopImp;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HybridGameLoopTest {

    private HybridGameSpy game = new HybridGameSpy();
    private HybridGameLoopImp sut = new HybridGameLoopImp(game);

    @Test
    void IfInputWithR0C0GetsPlayed_ShouldPlayR0C0() {
        Input input = new Input(0, 0);

        sut.play(input);

        assertPlayedInputEquals(new Input(0, 0));
    }

    @Test
    void IfInputWithR1C2GetsPlayed_ShouldPlayR1C2() {
        Input input = new Input(1, 2);

        sut.play(input);

        assertPlayedInputEquals(new Input(1, 2));
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = game.getPlayedInput();
        assertEquals(expected, actual);
    }

//    @Test
//    void IfGameCanBePlayedOnceWithoutInput_ShouldPlayOnce() {
//        game.setTimesPlayable(1);
//
//        sut.run();
//
//        assertHasPlayedTimes(1);
//    }

//    private void assertHasPlayedTimes(int expected) {
//        int acutal = game.getPlayedTimesWithoutInput();
//    }
}
