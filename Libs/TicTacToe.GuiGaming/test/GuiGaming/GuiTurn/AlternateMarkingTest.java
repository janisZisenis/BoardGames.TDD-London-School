package GuiGaming.GuiTurn;

import Data.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlternateMarkingTest {

    private GuiPlayerSpy first = new GuiPlayerSpy();
    private GuiPlayerSpy second = new GuiPlayerSpy();
    private GuiTwoPlayerTurn sut = new GuiTwoPlayerTurn(first, second);

    private Field field = new Field(0, 0);

    @Test
    void IfGameProcessesOnce_FirstPlayerShouldHaveMarkedOnce() {
        sut.process(field);

        assertFirstHasMarkedTimes(1);
    }

    @Test
    void IfGameProcessesTwice_FirstPlayerShouldHaveMarkedOnce() {
        processTwice(field);

        assertFirstHasMarkedTimes(1);
    }

    @Test
    void IfGameProcessesTwice_SecondPlayerShouldHaveMarkedOnce() {
        processTwice(field);

        assertSecondHasMarkedTimes(1);
    }

    @Test
    void IfGameProcessesThreeTimes_FirstPlayerShouldHaveMarkedTwice() {
        processThreeTimes(field);

        assertFirstHasMarkedTimes(2);
    }

    @Test
    void IfGameProcessesFourTimes_SecondPlayerShouldHaveMarkedTwice() {
        processFourTimes(field);

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

    private void processTwice(Field field) {
        sut.process(field);
        sut.process(field);
    }

    private void processThreeTimes(Field field) {
        processTwice(field);
        sut.process(field);
    }

    private void processFourTimes(Field field) {
        processThreeTimes(field);
        sut.process(field);
    }

}
