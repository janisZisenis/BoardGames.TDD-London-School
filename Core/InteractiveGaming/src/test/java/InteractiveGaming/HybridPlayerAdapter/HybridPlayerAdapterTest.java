package InteractiveGaming.HybridPlayerAdapter;

import Gaming.GameFacade.PlayerMock;
import Input2D.Input.Input;
import InteractiveGaming.HybridGameImp.HybridPlayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HybridPlayerAdapterTest {

    private PlayerMock player = new PlayerMock();
    private HybridPlayerAdapter sut = new HybridPlayerAdapter(player);

    @Test
    void FreshInstance_ShouldBeComputer() {
        assertIsNotInputTurn();
    }

    private void assertIsNotInputTurn() {
        boolean actual = sut.isInputTurn();
        assertFalse(actual);
    }

    @Test
    void IfGetsPlayedInput_ShouldThrow() {
        Input input = new Input(0, 0);

        Executable act = () -> sut.playInput(input);

        assertThrows(HybridPlayer.CannotPlayWithInput.class, act);
    }

    @Test
    void IfGetsPlayedWithoutInput_ShouldPlay() {
        player.expectGetsPlayedTimes(1);

        sut.play();

        player.verifyAll();
    }

}
