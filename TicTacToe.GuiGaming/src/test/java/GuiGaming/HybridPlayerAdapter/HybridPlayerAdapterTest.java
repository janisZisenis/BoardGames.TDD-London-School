package GuiGaming.HybridPlayerAdapter;

import GuiGaming.MultiHybridPlayer.HybridPlayer;
import InputGeneration.Input.Input;
import SequentialGaming.GameFacade.PlayerSpy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class HybridPlayerAdapterTest {

    private PlayerSpy player = new PlayerSpy();
    private HybridPlayerAdapter sut = new HybridPlayerAdapter(player);

    @Test
    void FreshInstance_ShouldNotNeedInput() {
        assertDoesNotNeedInput();
    }

    private void assertDoesNotNeedInput() {
        boolean actual = sut.needsInput();
        assertFalse(actual);
    }

    @Test
    void IfGetsPlayedWithInput_ShouldThrow() {
        Input input = new Input(0, 0);

        Executable act = () -> sut.play(input);

        assertThrows(HybridPlayer.DoesNotNeedInputButWasPlayedWith.class, act);
    }

    @Test
    void IfGetsPlayedWithoutInput_ShouldPlay() {
        sut.play();

        assertHasPlayedTimes(1);
    }

    private void assertHasPlayedTimes(int expected) {
        int actual = player.getPlayedTimes();
        assertEquals(expected, actual);
    }

}
