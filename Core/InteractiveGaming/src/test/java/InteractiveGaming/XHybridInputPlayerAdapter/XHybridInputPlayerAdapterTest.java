package InteractiveGaming.XHybridInputPlayerAdapter;

import Input2D.Input.Input;
import InteractiveGaming.HybridInputPlayerAdapter.InputPlayerSpy;
import InteractiveGaming.XMultiHybridPlayer.XHybridPlayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class XHybridInputPlayerAdapterTest {

    private InputPlayerSpy player = new InputPlayerSpy();
    private XHybridInputPlayerAdapter sut  = new XHybridInputPlayerAdapter(player);

    @Test
    void FreshInstance_ShouldNeedInput() {
        assertIsInputTurn();
    }

    private void assertIsInputTurn() {
        boolean actual = sut.isInputTurn();
        assertTrue(actual);
    }

    @Test
    void IfGetsPlayedWithoutInputShouldThrow() {
        Executable act = () -> sut.play();

        assertThrows(XHybridPlayer.CannotPlayWithoutInput.class, act);
    }


    @Test
    void IfGetsPlayedWithInput_ShouldPlayInput() {
        Input input = new Input(0, 0);

        sut.playInput(input);

        assertPlayedInputEquals(input);
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = player.getPlayedInput();
        assertEquals(expected, actual);
    }

}
