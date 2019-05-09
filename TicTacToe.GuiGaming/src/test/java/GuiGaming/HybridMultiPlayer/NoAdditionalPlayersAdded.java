package GuiGaming.HybridMultiPlayer;

import Domain.Data.Field.Field;
import GuiGaming.GuiMultiPlayer.GuiPlayerSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoAdditionalPlayersAdded {

    private GuiPlayerSpy first = new GuiPlayerSpy();
    private HybridMultiPlayer sut = new HybridMultiPlayer(first);

    private Field field = new Field(0, 0);

    @Test
    void IfGetsPlayedOnce_ShouldHavePlayedTheFirstOnce() {
        sut.play(field);

        assertPlayedTimes(1);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstTwice() {
        sut.play(field);
        sut.play(field);

        assertPlayedTimes(2);
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheFirstThreeTimes() {
        sut.play(field);
        sut.play(field);
        sut.play(field);

        assertPlayedTimes(3);
    }

    @Test
    void IfGetsPlayedFourTimes_ShouldHavePlayedTheFirstFourTimes() {
        sut.play(field);
        sut.play(field);
        sut.play(field);
        sut.play(field);

        assertPlayedTimes(4);
    }

    private void assertPlayedTimes(int expected) {
        int actual = first.getPlayedTimes();
        assertEquals(expected, actual);
    }

}
