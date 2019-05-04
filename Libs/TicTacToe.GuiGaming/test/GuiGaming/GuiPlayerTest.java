package GuiGaming;

import Board.Mark;
import Data.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuiPlayerTest {

    private MarkFieldServiceSpy service = new MarkFieldServiceSpy();
    private GuiPlayer sut;

    @Test
    void IfPlayerIsJohn_ShouldMarkAsJohn() {
        makeGuiPlayerIsJohn();
        Field field = new Field(0, 0);

        sut.mark(field);

        assertMarkedAs(Mark.John);
    }

    @Test
    void IfPlayerIsHaley_ShouldMarkAsHaley() {
        makeGuiPlayerIsHaley();
        Field field = new Field(0, 0);

        sut.mark(field);

        assertMarkedAs(Mark.Haley);
    }

    @Test
    void IfTheFieldIsR0C0_ShouldMarkR0C0() {
        makeGuiPlayerIsJohn();
        Field field = new Field(0, 0);

        sut.mark(field);

        assertMarkedFieldEquals(field);
    }

    @Test
    void IfTheFieldIsR2C1_ShouldMarkR2C1() {
        makeGuiPlayerIsJohn();
        Field field = new Field(2, 1);

        sut.mark(field);

        assertMarkedFieldEquals(field);
    }

    private void assertMarkedAs(Mark expected) {
        Mark actual = service.getMark();
        assertEquals(expected, actual);
    }

    private void assertMarkedFieldEquals(Field expected) {
        Field actual = service.getMarkedField();
        assertEquals(expected, actual);
    }

    private void makeGuiPlayerIsJohn() {
        sut = new GuiPlayer(Mark.John, service);
    }

    private void makeGuiPlayerIsHaley() {
        sut = new GuiPlayer(Mark.Haley, service);
    }

}
