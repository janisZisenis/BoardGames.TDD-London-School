package HybridGaming.HybridPlayerAdapter;

import HybridGaming.HybridGameImp.HybridPlayer;
import InputGeneration.Input.Input;
import SequentialGaming.GameFacade.PlayerSpy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class HybridPlayerAdapterTest {

    private PlayerSpy player = new PlayerSpy();
    private HybridPlayerAdapter sut = new HybridPlayerAdapter(player);

    @Test
    void FreshInstance_ShouldBeComputer() {
        assertIsComputer();
    }

    private void assertIsComputer() {
        boolean actual = sut.isComputer();
        assertTrue(actual);
    }

    @Test
    void IfGetsPlayedHuman_ShouldThrow() {
        Input input = new Input(0, 0);

        Executable act = () -> sut.playHuman(input);

        assertThrows(HybridPlayer.CannotPlayComputerOnHumansTurn.class, act);
    }

    @Test
    void IfGetsPlayedComputer_ShouldPlayComputer() {
        sut.playComputer();

        assertHasPlayedTimes(1);
    }

    private void assertHasPlayedTimes(int expected) {
        int actual = player.getPlayedTimes();
        assertEquals(expected, actual);
    }

}
