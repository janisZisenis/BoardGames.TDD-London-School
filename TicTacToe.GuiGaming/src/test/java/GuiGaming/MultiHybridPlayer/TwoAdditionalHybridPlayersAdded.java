//package GuiGaming.MultiHybridPlayer;
//
//import GuiGaming.HybridGameFacade.HybridPlayerSpy;
//import InputGeneration.Input.Input;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TwoAdditionalHybridPlayersAdded {
//
//    private HybridPlayerSpy first = new HybridPlayerSpy();
//    private MultiHybridPlayer sut = new MultiHybridPlayer(first);
//
//    private HybridPlayerSpy second = new HybridPlayerSpy();
//    private HybridPlayerSpy third = new HybridPlayerSpy();
//
//    @BeforeEach
//    void SetUp() {
//        sut.add(second);
//        sut.add(third);
//    }
//
//
//    @Test
//    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheSecondOnce() {
//        sut.play();
//        sut.play();
//
//
//        assertHasPlayedTimes(second, 1);
//    }
//
//    @Test
//    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheThirdOnce() {
//        sut.play();
//        sut.play();
//        sut.play();
//
//        assertHasPlayedTimes(third, 1);
//    }
//
//    private void assertHasPlayedTimes(HybridPlayerSpy p, int expected) {
//        int actual = p.getPlayedTimes();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void IfGetsPlayedWithInputR0C0Twice_ShouldPlayInputR0C0OnSecond() {
//        Input input = new Input(0, 0);
//
//        sut.play(input);
//        sut.play(input);
//
//        assertPlayedInputEquals(second, new Input(0, 0));
//    }
//
//    private void assertPlayedInputEquals(HybridPlayerSpy p, Input expected) {
//        Input actual = p.getPlayedInput();
//        assertEquals(expected, actual);
//    }
//
//}
