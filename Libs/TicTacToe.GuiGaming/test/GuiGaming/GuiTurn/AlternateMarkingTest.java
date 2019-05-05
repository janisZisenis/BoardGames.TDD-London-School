package GuiGaming.GuiTurn;

import Domain.Data.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlternateMarkingTest {

    private GuiPlayerSpy first = new GuiPlayerSpy();
    private GuiPlayerSpy second = new GuiPlayerSpy();
    private GuiTwoPlayerTurn sut = new GuiTwoPlayerTurn(first, second);

    private Field field = new Field(0, 0);

    @Test
    void IfGameProcessesOnce_FirstPlayerShouldHaveMarkedOnce() {
        sut.play(field);

        assertFirstHasMarkedTimes(1);
    }

    @Test
    void IfGameProcessesTwice_FirstPlayerShouldHaveMarkedOnce() {
        playTwice(field);

        assertFirstHasMarkedTimes(1);
    }

    @Test
    void IfGameProcessesTwice_SecondPlayerShouldHaveMarkedOnce() {
        playTwice(field);

        assertSecondHasMarkedTimes(1);
    }

    @Test
    void IfGameProcessesThreeTimes_FirstPlayerShouldHaveMarkedTwice() {
        playThreeTimes(field);

        assertFirstHasMarkedTimes(2);
    }

    @Test
    void IfGameProcessesFourTimes_SecondPlayerShouldHaveMarkedTwice() {
        playFourTimes(field);

        assertSecondHasMarkedTimes(2);
    }

    private void assertFirstHasMarkedTimes(int times) {
        int actual = first.getMarkedCount();
        int expected = times;
        assertEquals(expected, actual);
    }

    private void assertSecondHasMarkedTimes(int times) {
        int actual = second.getMarkedCount();
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
