package HybridGaming.HybridInputPlayerAdapter;

import HybridGaming.HybridGameImp.HybridPlayer;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class HybridInputPlayerAdapterTest {

    private InputPlayerSpy player = new InputPlayerSpy();
    private HybridInputPlayerAdapter sut  = new HybridInputPlayerAdapter(player);

    @Test
    void FreshInstance_ShouldNeedInput() {
        assertIsNotComputer();
    }

    private void assertIsNotComputer() {
        boolean actual = sut.isComputer();
        assertFalse(actual);
    }


    @Test
    void IfGetsPlayedWithoutInputShouldThrow() {
        Executable act = () -> sut.playComputer();

        assertThrows(HybridPlayer.CannotPlayComputerOnHumansTurn.class, act);
    }


    @Test
    void IfInputIsR0C0_ShouldPlayInputWithR0C0() {
        Input input = new Input(0, 0);

        sut.playHuman(input);

        assertPlayedInputEquals(new Input(0, 0));
    }

    @Test
    void IfInputIsR1C2_ShouldPlayInputWithR1C2() {
        Input input = new Input(1, 2);

        sut.playHuman(input);

        assertPlayedInputEquals(new Input(1, 2));
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = player.getPlayedInput();
        assertEquals(expected, actual);
    }

}
