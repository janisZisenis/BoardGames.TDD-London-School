package InteractiveGaming.XMultiHybridPlayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XOneAdditionalHybridPlayerAdded {

    private XHybridPlayerSpy first = new XHybridPlayerSpy();
    private XMultiHybridPlayer sut = new XMultiHybridPlayer(first);

    private XHybridPlayerSpy second = new XHybridPlayerSpy();

    @BeforeEach
    void SetUp() {
        sut.add(second);
    }


    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstOnce() {
        sut.play();
        sut.play();

        assertPlayedTimes(first, 1);
    }

//    @Test
//    void IfGetsPlayedTwice_ShouldHavePlayedTheSecondOnce() {
//        sut.play();
//        sut.play();
//
//        assertPlayedTimes(second, 1);
//    }

//    @Test
//    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheFirstTwice() {
//        sut.play();
//        sut.play();
//        sut.play();
//
//        assertPlayedTimes(first, 2);
//    }


//    @Test
//    void IfGetsPlayedOnceThenResetThenPlayedOnce_FirstShouldHavePlayedTwice() {
//        sut.play();
//        sut.reset();
//
//        sut.play();
//
//        assertPlayedTimes(first, 2);
//    }

    private void assertPlayedTimes(XHybridPlayerSpy p, int expected) {
        int actual = p.getTimesPlayedWithoutInput();
        assertEquals(expected, actual);
    }

}
