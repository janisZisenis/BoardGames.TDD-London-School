package GuiGaming.GuiTurn;

import Domain.Data.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GuiTurnTest {

    private GuiPlayerSpy first = new GuiPlayerSpy();
    private GuiPlayerSpy second = new GuiPlayerSpy();
    private GuiTwoPlayerTurn sut = new GuiTwoPlayerTurn(first, second);

    @Test
    void IfFieldIsR0C1_ShouldPassFieldR0C1ToFirst() {
        Field field = new Field(0, 1);

        sut.play(field);

        assertPlayedFieldEquals(new Field(0, 1));
    }

    @Test
    void IfFieldIsR1C2_ShouldPassFieldR1C2ToFirst() {
        Field field = new Field(1, 2);

        sut.play(field);

        assertPlayedFieldEquals(new Field(1, 2));
    }

    @Test
    void IfPlaysOnce_FirstPlayerShouldHaveMarkedOnce() {
        Field field = new Field(0, 0);

        sut.play(field);

        assertFirstHasPlayedTimes(1);
    }

    @Test
    void IfPlaysTwice_FirstPlayerShouldHaveMarkedOnce() {
        Field field = new Field(0, 0);

        playTwice(field);

        assertFirstHasPlayedTimes(1);
    }

    @Test
    void IfPlaysTwice_SecondPlayerShouldHaveMarkedOnce() {
        Field field = new Field(0, 0);

        playTwice(field);

        assertSecondHasPlayedTimes(1);
    }

    @Test
    void IfPlaysThreeTimes_FirstPlayerShouldHaveMarkedTwice() {
        Field field = new Field(0, 0);

        playThreeTimes(field);

        assertFirstHasPlayedTimes(2);
    }

    @Test
    void IfPlaysFourTimes_SecondPlayerShouldHaveMarkedTwice() {
        Field field = new Field(0, 0);

        playFourTimes(field);

        assertSecondHasPlayedTimes(2);
    }

    private void assertPlayedFieldEquals(Field expected) {
        Field actual = first.getPlayedField();
        assertEquals(expected, actual);
    }

    private void assertFirstHasPlayedTimes(int times) {
        int actual = first.getPlayedTimes();
        int expected = times;
        assertEquals(expected, actual);
    }

    private void assertSecondHasPlayedTimes(int times) {
        int actual = second.getPlayedTimes();
        int expected = times;
        assertEquals(expected, actual);
    }

    private void playTwice(Field field) {
        sut.play(field);
        sut.play(field);
    }

    private void playThreeTimes(Field field) {
        playTwice(field);
        sut.play(field);
    }

    private void playFourTimes(Field field) {
        playThreeTimes(field);
        sut.play(field);
    }

}
