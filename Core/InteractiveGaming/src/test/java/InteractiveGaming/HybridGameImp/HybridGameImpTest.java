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
    void IfPlayerIsComputer_NextShouldNotBeHuman() {
        player.setTimesIsComputer(1);

        assertNextIsNotHuman();
    }

    private void assertNextIsNotHuman() {
        boolean actual = sut.nextIsInputTurn();
        assertFalse(actual);
    }

    @Test
    void IfPlayerIsNotComputer_NextShouldBeHuman() {
        player.setTimesIsComputer(0);

        assertNextIsHuman();
    }

    private void assertNextIsHuman() {
        boolean actual = sut.nextIsInputTurn();
        assertTrue(actual);
    }

    @Test
    void IfPlayerIsComputer_PlayHumanShouldThrow() {
        player.setTimesIsComputer(1);
        Input input = new Input(0, 0);

        Executable act = () -> sut.playInput(input);

        assertThrows(HybridGame.CannotPlayHumanOnComputersTurn.class, act);
    }

    @Test
    void IfPlayerIsNotComputerAndInputIsR0C0_ShouldPlayInputR0C0() {
        player.setTimesIsComputer(0);
        Input input = new Input(0, 0);

        sut.playInput(input);

        assertPlayedInputEquals(new Input(0, 0));
    }


    @Test
    void IfPlayerIsNotComputerAndInputIsR1C2_ShouldPlayInputR1C2() {
        player.setTimesIsComputer(0);
        Input input = new Input(1, 2);

        sut.playInput(input);

        assertPlayedInputEquals(new Input(1, 2));
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = player.getPlayedInput();
        assertEquals(expected, actual);
    }

}
