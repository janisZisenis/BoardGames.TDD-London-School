//package GuiGaming.MultiHybridPlayer;
//
//import GuiGaming.MultiGuiPlayer.GuiPlayerSpy;
//import InputGeneration.Input.Input;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.function.Executable;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class FirstIsGuiPlayer {
//
//    private GuiPlayerSpy first = new GuiPlayerSpy();
//    private MultiHybridPlayer sut = new MultiHybridPlayer(first);
//
//    @Test
//    void FreshInstance_ShouldNeedInput() {
//        assertNeedsInput(sut);
//    }
//
//    private void assertNeedsInput(MultiHybridPlayer sut) {
//        boolean actual = sut.needsInput();
//        assertTrue(actual);
//    }
//
//
//    @Test
//    void IfGetsPlayedWithoutInput_ShouldThrowException() {
//        Executable act = () -> sut.play();
//
//        assertThrows(MultiHybridPlayer.NeedsInputButWasPlayedWithout.class, act);
//    }
//
//    @Test
//    void IfGetsPlayedWithInputWithR0C0_ShouldPlayInputWithR0C0() {
//        Input input = new Input(0, 0);
//
//        sut.play(input);
//
//        assertPlayedInputEquals(new Input(0, 0));
//    }
//
//    private void assertPlayedInputEquals(Input expected) {
//        Input actual = first.getPlayedInput();
//        assertEquals(expected, actual);
//    }
//
//}
