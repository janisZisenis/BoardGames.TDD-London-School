package InteractiveGaming.XHybridGameImp;

import Gaming.GameFacade.GameOverRuleDummy;
import Input2D.Input.Input;
import InteractiveGaming.XMultiHybridPlayer.XHybridPlayer;
import InteractiveGaming.XMultiHybridPlayer.XHybridPlayerSpy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class XHybridGameImpTest {

    private GameOverRuleDummy rule = new GameOverRuleDummy();
    private XHybridPlayerSpy player = new XHybridPlayerSpy();
    private XHybridGameImp sut = new XHybridGameImp(rule, player);

    @Test
    void IfNextIsNotInputTurn_NextShouldNotBeInputTurnEither() {
        player.setIsInputTurn(false);

        assertNextIsNotInputTurn();
    }

    private void assertNextIsNotInputTurn() {
        boolean actual = sut.nextIsInputTurn();
        assertFalse(actual);
    }


    @Test
    void IfNextIsInputTurn_NextShouldBeInputTurnEither() {
        player.setIsInputTurn(true);

        assertNextIsInputTurn();
    }

    private void assertNextIsInputTurn() {
        boolean actual = sut.nextIsInputTurn();
        assertTrue(actual);
    }

    @Test
    void IfNextIsNotInputTurn_PlayInputShouldThrow() {
        player.setIsInputTurn(false);
        Input input = new Input(0, 0);

        Executable act = () -> sut.playInput(input);

        assertThrows(XHybridPlayer.CannotPlayWithInput.class, act);
    }


    @Test
    void IfNextIsInputTurn_ShouldPlayInput() {
        player.setIsInputTurn(true);
        Input input = new Input(0, 0);

        sut.playInput(input);

        assertPlayedInputEquals(input);
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = player.getPlayedInput();
        assertEquals(expected, actual);
    }

}
