package GuiGaming;

import Board.Mark;
import Data.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuiPlayerTest {

    @Test
    void IfPlayerIsJohn_ShouldMarkAsJohn() {
        Field field = new Field(0, 0);
        MarkFieldServiceSpy service = new MarkFieldServiceSpy();
        GuiPlayer sut = new GuiPlayer(Mark.John, service);

        sut.mark(field);

        Mark actual = service.getMark();
        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }

    @Test
    void IfPlayerIsHaley_ShouldMarkAsHaley() {
        Field field = new Field(0, 0);
        MarkFieldServiceSpy service = new MarkFieldServiceSpy();
        GuiPlayer sut = new GuiPlayer(Mark.Haley, service);

        sut.mark(field);

        Mark actual = service.getMark();
        Mark expected = Mark.Haley;
        assertEquals(expected, actual);
    }


    @Test
    void IfTheFieldIsR0C0_ShouldMarkR0C0() {
        Field field = new Field(0, 0);
        MarkFieldServiceSpy service = new MarkFieldServiceSpy();
        GuiPlayer sut = new GuiPlayer(Mark.Haley, service);

        sut.mark(field);

        Field actual = service.getMarkedField();
        Field expected = field;
        assertEquals(expected, actual);
    }

    @Test
    void IfTheFieldIsR2C1_ShouldMarkR2C1() {
        Field field = new Field(2, 1);
        MarkFieldServiceSpy service = new MarkFieldServiceSpy();
        GuiPlayer sut = new GuiPlayer(Mark.Haley, service);

        sut.mark(field);

        Field actual = service.getMarkedField();
        Field expected = field;
        assertEquals(expected, actual);
    }

}
