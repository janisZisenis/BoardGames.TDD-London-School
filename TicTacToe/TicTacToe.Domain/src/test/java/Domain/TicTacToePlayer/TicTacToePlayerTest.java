package Domain.TicTacToePlayer;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Input2D.Input.Input;
import Input2D.InputGeneratorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToePlayerTest {

    private MarkFieldServiceSpy service = new MarkFieldServiceSpy();
    private InputGeneratorStub generator = new InputGeneratorStub();
    private TicTacToePlayer sut;

    @Test
    void IfR0C0IsGenerated_ShouldMarkR0C0() {
        makeInputIsGenerated(new Input(0, 0));

        sut.play();

        assertMarkedFieldEquals(new Field(0, 0));
    }

    @Test
    void IfR2C1IsGenerated_ShouldMarkR2C1() {
        makeInputIsGenerated(new Input(2, 1));

        sut.play();

        assertMarkedFieldEquals(new Field(2, 1));
    }

    @Test
    void IfPlayerIsJohn_ShouldMarkAsJohn() {
        generator.setGeneratedInput(new Input(0, 0));
        makePlayerIs(Mark.John);

        sut.play();

        assertPlacedMarkIs(Mark.John);
    }

    @Test
    void IfPlayerIsHaley_ShouldMarkAsHaley() {
        generator.setGeneratedInput(new Input(0, 0));
        makePlayerIs(Mark.Haley);

        sut.play();

        assertPlacedMarkIs(Mark.Haley);
    }

    private void makeInputIsGenerated(Input input) {
        makePlayerIs(Mark.Haley);
        generator.setGeneratedInput(input);
    }

    private void makePlayerIs(Mark m) {
        sut = new TicTacToePlayer(m, service, generator);
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
