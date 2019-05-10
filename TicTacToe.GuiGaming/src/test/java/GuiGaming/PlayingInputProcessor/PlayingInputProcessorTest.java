package GuiGaming.PlayingInputProcessor;

import Domain.Data.Field.Field;
import GuiGaming.MultiGuiPlayer.GuiPlayerSpy;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayingInputProcessorTest {

    private GuiPlayerSpy player = new GuiPlayerSpy();
    private PlayingInputProcessor sut = new PlayingInputProcessor(player);

    @Test
    void IfInputIsR0C0_ShouldPlayFieldR0C0() {
        Input input = new Input(0, 0);

        sut.process(input);

        assertPlayedFieldEquals(new Field(0, 0));
    }

    @Test
    void IfInputIsR1C2_ShouldPlayFieldR1C2() {
        Input input = new Input(1, 2);

        sut.process(input);

        assertPlayedFieldEquals(new Field(1, 2));
    }

    private void assertPlayedFieldEquals(Field expected) {
        Field actual = player.getPlayedField();
        assertEquals(expected, actual);
    }
}
