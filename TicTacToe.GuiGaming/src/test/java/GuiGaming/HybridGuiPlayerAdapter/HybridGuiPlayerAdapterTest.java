package GuiGaming.HybridGuiPlayerAdapter;

import GuiGaming.MultiGuiPlayer.GuiPlayerSpy;
import GuiGaming.MultiHybridPlayer.HybridPlayer;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HybridGuiPlayerAdapterTest {

    private GuiPlayerSpy player = new GuiPlayerSpy();
    private HybridGuiPlayerAdapter sut  = new HybridGuiPlayerAdapter(player);

    @Test
    void FreshInstance_ShouldNeedInput() {
        assertNeedsInput();
    }

    private void assertNeedsInput() {
        boolean actual = sut.needsInput();
        assertTrue(actual);
    }


    @Test
    void IfGetsPlayedWithoutInputShouldThrow() {
        Executable act = () -> sut.play();

        assertThrows(HybridPlayer.NeedsInputButWasPlayedWithout.class, act);
    }


    @Test
    void IfInputIsR0C0_ShouldPlayInputWithR0C0() {
        Input input = new Input(0, 0);

        sut.play(input);

        assertPlayedInputEquals(new Input(0, 0));
    }

    @Test
    void IfInputIsR1C2_ShouldPlayInputWithR1C2() {
        Input input = new Input(1, 2);

        sut.play(input);

        assertPlayedInputEquals(new Input(1, 2));
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = player.getPlayedInput();
        assertEquals(expected, actual);
    }

}
