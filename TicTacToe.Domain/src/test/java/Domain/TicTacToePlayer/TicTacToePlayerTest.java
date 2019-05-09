package Domain.TicTacToePlayer;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToePlayerTest {

    private MarkFieldServiceSpy service = new MarkFieldServiceSpy();
    private FieldGeneratorStub strategy = new FieldGeneratorStub();
    private TicTacToePlayer sut;

    @Test
    void IfMarkIsJohn_ShouldMarkAsJohn() {
        makeMarkIs(Mark.John);

        sut.play();

        assertPlacedMarkIs(Mark.John);
    }

    @Test
    void IfMarkIsHaley_ShouldMarkAsHaley() {
        makeMarkIs(Mark.Haley);

        sut.play();

        assertPlacedMarkIs(Mark.Haley);
    }

    @Test
    void IfR0C0IsGenerated_ShouldMarkR0C0() {
        makeFieldIsGenerated(new Field(0, 0));

        sut.play();

        assertMarkedFieldEquals(new Field(0, 0));
    }

    @Test
    void IfR2C1IsGenerated_ShouldMarkR2C1() {
        makeFieldIsGenerated(new Field(2, 1));

        sut.play();

        assertMarkedFieldEquals(new Field(2, 1));
    }

    private void makeMarkIs(Mark m) {
        sut = new TicTacToePlayer(m, service, strategy);
    }

    private void makeFieldIsGenerated(Field field) {
        makeMarkIs(Mark.Haley);
        strategy.setGeneratedField(field);
    }

    private void assertPlacedMarkIs(Mark expected) {
        Mark actual = service.getPlacedMark();
        assertEquals(expected, actual);
    }

    private void assertMarkedFieldEquals(Field expected) {
        Field actual = service.getMarkedField();
        assertEquals(expected, actual);
    }

}
