package InteractiveGaming.XHybridPlayerAdapter;

import Gaming.GameFacade.PlayerMock;
import Input2D.Input.Input;
import InteractiveGaming.XMultiHybridPlayer.XHybridPlayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XHybridPlayerAdapterTest {

    private PlayerMock player = new PlayerMock();
    private XHybridPlayerAdapter sut = new XHybridPlayerAdapter(player);

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

        assertThrows(XHybridPlayer.CannotPlayWithInput.class, act);
    }

    @Test
    void IfGetsPlayedWithoutInput_ShouldPlay() {
        player.expectGetsPlayedTimes(1);

        sut.play();

        player.verifyAll();
    }

}
