//package GuiGaming.MultiHybridPlayer;
//
//import InputGeneration.Input.Input;
//import SequentialGaming.GameFacade.PlayerSpy;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.function.Executable;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class FirstIsPlayer {
//
//    private PlayerSpy first = new PlayerSpy();
//    private MultiHybridPlayer sut = new MultiHybridPlayer(first);
//
//    @Test
//    void FreshInstance_ShouldNeedInput() {
//        assertDoesNotNeedInput();
//    }
//
//    private void assertDoesNotNeedInput() {
//        boolean actual = sut.needsInput();
//        assertFalse(actual);
//    }
//
//
//    @Test
//    void IfFirstIsPlayer_PlayingInputShouldThrow() {
//        Input input = new Input(0, 0);
//
//        Executable act = () -> sut.play(input);
//
//        assertThrows(MultiHybridPlayer.DoesNotNeedInputButWasPlayedWith.class ,act);
//    }
//
//    @Test
//    void IfFirstIsPlayer_PlayWithoutInputShouldPlayFirst() {
//        sut.play();
//
//        assertFirstHasPlayedTimes(1);
//    }
//
//    private void assertFirstHasPlayedTimes(int expected) {
//        int actual = first.getPlayedTimes();
//        assertEquals(expected, actual);
//    }
//
//}
