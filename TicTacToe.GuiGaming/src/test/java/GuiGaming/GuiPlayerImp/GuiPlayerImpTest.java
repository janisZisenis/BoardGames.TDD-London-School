package GuiGaming.GuiPlayerImp;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.Turn.MarkFieldServiceSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuiPlayerImpTest {

    private MarkFieldServiceSpy service = new MarkFieldServiceSpy();
    private GuiPlayerImp sut;

    @Test
    void IfPlayerIsJohn_ShouldMarkAsJohn() {
        makeGuiPlayerIsJohn();
        Field field = new Field(0, 0);

        sut.play(field);

        assertMarkedAs(Mark.John);
    }

    @Test
    void IfPlayerIsHaley_ShouldMarkAsHaley() {
        makeGuiPlayerIsHaley();
        Field field = new Field(0, 0);

        sut.play(field);

        assertMarkedAs(Mark.Haley);
    }

    @Test
    void IfTheFieldIsR0C0_ShouldMarkR0C0() {
        makeGuiPlayerIsJohn();
        Field field = new Field(0, 0);

        sut.play(field);

        assertMarkedFieldEquals(field);
    }

    @Test
    void IfTheFieldIsR2C1_ShouldMarkR2C1() {
        makeGuiPlayerIsJohn();
        Field field = new Field(2, 1);

        sut.play(field);

        assertMarkedFieldEquals(field);
    }


    private void assertMarkedAs(Mark expected) {
        Mark actual = service.getPlacedMark();
        assertEquals(expected, actual);
    }

    private void assertMarkedFieldEquals(Field expected) {
        Field actual = service.getMarkedField();
        assertEquals(expected, actual);
    }

    private void makeGuiPlayerIsJohn() {
        sut = new GuiPlayerImp(Mark.John, service);
    }

    private void makeGuiPlayerIsHaley() {
        sut = new GuiPlayerImp(Mark.Haley, service);
    }

}
