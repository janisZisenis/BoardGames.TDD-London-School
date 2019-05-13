package GuiGaming.MultiGuiPlayer;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoAdditionalGuiPlayersAdded {

    private GuiPlayerSpy first = new GuiPlayerSpy();
    private MultiGuiPlayer sut = new MultiGuiPlayer(first);

    private GuiPlayerSpy second = new GuiPlayerSpy();
    private GuiPlayerSpy third = new GuiPlayerSpy();

    private Input input = new Input(0, 0);

    @BeforeEach
    void SetUp() {
        sut.add(second);
        sut.add(third);
    }


    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheSecondOnce() {
        sut.play(input);
        sut.play(input);

        int actual = second.getPlayedTimes();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheThirdOnce() {
        sut.play(input);
        sut.play(input);
        sut.play(input);

        int actual = third.getPlayedTimes();
        int expected = 1;
        assertEquals(expected, actual);
    }

}
