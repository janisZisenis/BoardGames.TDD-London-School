package GuiGaming.HybridMultiPlayer;

import Domain.Data.Field.Field;
import GuiGaming.GuiMultiPlayer.GuiPlayerSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoAdditionalGuiPlayersAdded {

    private GuiPlayerSpy first = new GuiPlayerSpy();
    private HybridMultiPlayer sut = new HybridMultiPlayer(first);

    private GuiPlayerSpy second = new GuiPlayerSpy();
    private GuiPlayerSpy third = new GuiPlayerSpy();

    private Field field = new Field(0, 0);

    @BeforeEach
    void SetUp() {
        sut.add(second);
        sut.add(third);
    }


    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheSecondOnce() {
        sut.play(field);
        sut.play(field);

        int actual = second.getPlayedTimes();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheThirdOnce() {
        sut.play(field);
        sut.play(field);
        sut.play(field);

        int actual = third.getPlayedTimes();
        int expected = 1;
        assertEquals(expected, actual);
    }

}
