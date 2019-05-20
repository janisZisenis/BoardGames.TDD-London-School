package InteractiveGaming.HybridGameImp;

import InteractiveGaming.HybridGameRunner.HybridGame;
import Input2D.Input.Input;
import Gaming.GameFacade.GameOverRuleDummy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class HybridGameImpTest {

    private GameOverRuleDummy rule = new GameOverRuleDummy();
    private HybridPlayerSpy player = new HybridPlayerSpy();
    private HybridGameImp sut = new HybridGameImp(rule, player);

    @Test
    void IfNextIsNotInputTurn_NextShouldNotBeInputTurnEither() {
        player.setNextIsNotInputTurn();

        assertNextIsNotInputTurn();
    }

    private void assertNextIsNotInputTurn() {
        boolean actual = sut.nextIsInputTurn();
        assertFalse(actual);
    }


    @Test
    void IfNextIsInputTurn_NextShouldBeInputTurnEither() {
        player.setNextIsInputTurn();

        assertNextIsInputTurn();
    }

    private void assertNextIsInputTurn() {
        boolean actual = sut.nextIsInputTurn();
        assertTrue(actual);
    }

    @Test
    void IfNextIsNotInputTurn_PlayInputShouldThrow() {
        player.setNextIsNotInputTurn();
        Input input = new Input(0, 0);

        Executable act = () -> sut.playInput(input);

        assertThrows(HybridGame.CannotPlayHumanOnComputersTurn.class, act);
    }


    @Test
    void IfNextIsInputTurn_ShouldPlayInput() {
        player.setNextIsInputTurn();
        Input input = new Input(0, 0);

        sut.playInput(input);

        assertPlayedInputEquals(input);
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = player.getPlayedInput();
        assertEquals(expected, actual);
    }

}
