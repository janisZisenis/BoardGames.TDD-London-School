package GuiGaming.GuiTurn;

import Data.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassingFieldTest {

    private GuiPlayerSpy first = new GuiPlayerSpy();
    private GuiPlayerSpy second = new GuiPlayerSpy();
    private GuiTwoPlayerTurn sut = new GuiTwoPlayerTurn(first, second);

    @Test
    void IfFieldIsR0C1_ShouldPassFieldR0C1ToFirst() {
        Field field = new Field(0, 1);

        sut.process(field);

        Field actual = first.getMarkedField();
        Field expected = field;
        assertEquals(expected, actual);
    }

}
