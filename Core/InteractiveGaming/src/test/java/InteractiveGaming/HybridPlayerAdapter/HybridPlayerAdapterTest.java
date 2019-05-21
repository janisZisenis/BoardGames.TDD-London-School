package InteractiveGaming.HybridPlayerAdapter;

import Gaming.GameFacade.PlayerMock;
import Input2D.Input.Input;
import InteractiveGaming.HybridGameImp.HybridPlayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class HybridPlayerAdapterTest {

    private PlayerMock player = new PlayerMock();
    private HybridPlayerAdapter sut = new HybridPlayerAdapter(player);

    @Test
    void FreshInstance_ShouldBeComputer() {
        assertIsComputer();
    }

    private void assertIsComputer() {
        boolean actual = sut.isNotInputTurn();
        assertTrue(actual);
    }

    @Test
    void IfGetsPlayedHuman_ShouldThrow() {
        Input input = new Input(0, 0);

        Executable act = () -> sut.playInput(input);

        assertThrows(HybridPlayer.CannotPlayWithInput.class, act);
    }

    @Test
    void IfGetsPlayedComputer_ShouldPlayComputer() {
        player.expectGetsPlayedTimes(1);

        sut.play();

        player.verifyAll();
    }

}
