package HybridGaming.TicTacToeInputPlayer;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.TicTacToePlayer.MarkFieldServiceSpy;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeInputPlayerTest {

    private MarkFieldServiceSpy service = new MarkFieldServiceSpy();
    private TicTacToeInputPlayer sut;

    @Test
    void IfPlayerIsJohn_ShouldMarkAsJohn() {
        makePlayerIsJohn();
        Input input = new Input(0, 0);

        sut.play(input);

        assertMarkedAs(Mark.John);
    }

    @Test
    void IfPlayerIsHaley_ShouldMarkAsHaley() {
        makePlayerIsHaley();
        Input input = new Input(0, 0);

        sut.play(input);

        assertMarkedAs(Mark.Haley);
    }

    @Test
    void IfTheFieldIsR0C0_ShouldMarkR0C0() {
        makePlayerIsJohn();
        Input input = new Input(0, 0);

        sut.play(input);

        assertMarkedFieldEquals(new Field(0, 0));
    }

    @Test
    void IfTheFieldIsR2C1_ShouldMarkR2C1() {
        makePlayerIsJohn();
        Input input = new Input(2, 1);

        sut.play(input);

        assertMarkedFieldEquals(new Field(2, 1));
    }


    private void assertMarkedAs(Mark expected) {
        Mark actual = service.getPlacedMark();
        assertEquals(expected, actual);
    }

    private void assertMarkedFieldEquals(Field expected) {
        Field actual = service.getMarkedField();
        assertEquals(expected, actual);
    }

    private void makePlayerIsJohn() {
        sut = new TicTacToeInputPlayer(Mark.John, service);
    }

    private void makePlayerIsHaley() {
        sut = new TicTacToeInputPlayer(Mark.Haley, service);
    }

}
