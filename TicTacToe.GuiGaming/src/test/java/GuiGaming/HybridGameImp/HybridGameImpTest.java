package GuiGaming.HybridGameImp;

import GuiGaming.HybridGameRunner.HybridGame;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class HybridGameImpTest {

    private GameOverRuleDummy rule = new GameOverRuleDummy();
    private HybridPlayerSpy player = new HybridPlayerSpy();
    private HybridGameImp sut = new HybridGameImp(rule, player);

    @Test
    void IfPlayerIsComputer_NextShouldBeComputer() {
        player.setTimesIsComputer(1);

        assertNextIsComputer();
    }

    private void assertNextIsComputer() {
        boolean actual = sut.nextIsComputer();
        assertTrue(actual);
    }

    @Test
    void IfPlayerIsNotHuman_NextShouldNotBeComputer() {
        player.setTimesIsComputer(0);

        assertNextIsNotComputer();
    }

    private void assertNextIsNotComputer() {
        boolean actual = sut.nextIsComputer();
        assertFalse(actual);
    }

    @Test
    void IfPlayerIsComputer_PlayHumanShouldThrow() {
        player.setTimesIsComputer(1);
        Input input = new Input(0, 0);

        Executable act = () -> sut.playHuman(input);

        assertThrows(HybridGame.CannotPlayHumanOnComputersTurn.class, act);
    }

    @Test
    void IfPlayerIsNotComputerAndInputIsR0C0_ShouldPlayInputR0C0() {
        player.setTimesIsComputer(0);
        Input input = new Input(0, 0);

        sut.playHuman(input);

        assertPlayedInputEquals(new Input(0, 0));
    }


    @Test
    void IfPlayerIsNotComputerAndInputIsR1C2_ShouldPlayInputR1C2() {
        player.setTimesIsComputer(0);
        Input input = new Input(1, 2);

        sut.playHuman(input);

        assertPlayedInputEquals(new Input(1, 2));
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = player.getPlayedInput();
        assertEquals(expected, actual);
    }

}
