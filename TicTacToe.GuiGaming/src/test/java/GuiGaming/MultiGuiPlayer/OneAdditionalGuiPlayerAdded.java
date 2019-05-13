package GuiGaming.MultiGuiPlayer;

import Domain.Data.Field.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneAdditionalGuiPlayerAdded {

    private GuiPlayerSpy first = new GuiPlayerSpy();
    private MultiGuiPlayer sut = new MultiGuiPlayer(first);

    private GuiPlayerSpy second = new GuiPlayerSpy();
    private Field field = new Field(0, 0);

    @BeforeEach
    void SetUp() {
        sut.add(second);
    }


    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstOnce() {
        sut.play(field);
        sut.play(field);

        int actual = first.getPlayedTimes();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheSecondOnce() {
        sut.play(field);
        sut.play(field);

        int actual = second.getPlayedTimes();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void IfGetsPlayedFourTimes_ShouldHavePlayedTheSecondTwice() {
        sut.play(field);
        sut.play(field);
        sut.play(field);
        sut.play(field);

        int actual = second.getPlayedTimes();
        int expected = 2;
        assertEquals(expected, actual);
    }

}
