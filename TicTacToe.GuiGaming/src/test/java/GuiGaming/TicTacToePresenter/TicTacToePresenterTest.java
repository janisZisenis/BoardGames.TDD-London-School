package GuiGaming.TicTacToePresenter;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToePresenterTest {

    private BoardViewSpy view = new BoardViewSpy();
    private TicTacToeSpy tictactoe = new TicTacToeSpy();
    private TicTacToePresenter sut = new TicTacToePresenter(tictactoe, view);

    @Test
    void IfBoardIsClickedWithR0C0_ShouldProcessInputWithR0C0() {
        sut.onBoardClicked(0, 0);

        assertProcessedInputEquals(new Input(0, 0));
    }

    @Test
    void IfBoardIsClickedWithR1C2_ShouldProcessInputWithR1C2() {
        sut.onBoardClicked(1, 2);

        assertProcessedInputEquals(new Input(1, 2));
    }

    private void assertProcessedInputEquals(Input expected) {
        Input actual = tictactoe.getProcessed();
        assertEquals(expected, actual);
    }


    @Test
    void IfFieldR0C0GetsMarked_ShouldSetMarkOnR0C0() {
        Field field = new Field(0, 0);
        tictactoe.addMarkedField(field, Mark.John);

        sut.onFieldUpdated(field);

        assertFieldWasSet(new Field(0, 0));
    }

    @Test
    void IfFieldR1C2GetsMarked_ShouldSetMarkOnR1C2() {
        Field field = new Field(1, 2);
        tictactoe.addMarkedField(field, Mark.John);

        sut.onFieldUpdated(field);

        assertFieldWasSet(new Field(1, 2));
    }

    private void assertFieldWasSet(Field expected) {
        Field actual = view.getSetField();
        assertEquals(expected, actual);
    }


    @Test
    void IfFieldGetsMarkedWithJohn_ShouldSetJohn() {
        Field field = new Field(0, 0);
        tictactoe.addMarkedField(field, Mark.John);

        sut.onFieldUpdated(field);

        assertFieldWasSetToJohn();
    }

    @Test
    void IfFieldGetsMarkedWithHaley_ShouldSetHaley() {
        Field field = new Field(0, 0);
        tictactoe.addMarkedField(field, Mark.Haley);

        sut.onFieldUpdated(field);

        assertFieldWasSetToHaley();
    }

    private void assertFieldWasSetToHaley() {
        Mark actual = view.getSetMark();
        Mark expected = Mark.Haley;
        assertEquals(expected, actual);
    }

    private void assertFieldWasSetToJohn() {
        Mark actual = view.getSetMark();
        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }


    @Test
    void IfFieldR0C0GetsUnmarked_ShouldResetR0C0() {
        Field field = new Field(0, 0);

        sut.onFieldUpdated(field);

        assertClearedFieldEquals(new Field(0, 0));
    }

    @Test
    void IfFieldR1C2GetsUnmarked_ShouldResetR1C2() {
        Field field = new Field(1, 2);

        sut.onFieldUpdated(field);

        assertClearedFieldEquals(new Field(1, 2));
    }

    @Test
    void IfFieldIsNotUnmarked_ShouldNotSetField() {
        Field field = new Field(0, 0);

        sut.onFieldUpdated(field);

        assertHasNotSetField();
    }

    @Test
    void IfFieldIsMarked_ShouldNotClearField() {
        Field field = new Field(0, 0);

        sut.onFieldUpdated(field);

        assertHasNotCleared();
    }

    private void assertHasNotSetField() {
        boolean actual = view.hasSetField();
        assertFalse(actual);
    }

    private void assertClearedFieldEquals(Field expected) {
        Field actual = view.getClearedField();
        assertEquals(expected, actual);
    }

    private void assertHasNotCleared() {
        boolean actual = view.hasCleared();
        assertFalse(actual);
    }


    @Test
    void IfWinnerIsProvided_ShouldHighLightTheWinningLine() {
        Line line = new Line(new Field(0, 0), new Field(0, 1), new Field(0, 2));
        tictactoe.setWinningLine(line);
        Field field = new Field(2, 2);

        sut.onFieldUpdated(field);

        assertHighlightedLineEquals(line);
    }

    @Test
    void IfNoWinnerIsProvided_ShouldNotHighLight() {
        Field field = new Field(2, 2);

        sut.onFieldUpdated(field);

        assertHasNotHighlighted();
    }

    private void assertHighlightedLineEquals(Line expected) {
        Line actual = view.getHighlighted();
        assertEquals(expected, actual);
    }

    private void assertHasNotHighlighted() {
        boolean actual = view.hasHighlighted();
        assertFalse(actual);
    }


    @Test
    void IfGameGetsStarted_ShouldSimulateComputerTurns() {
        sut.onStartClicked();

        boolean actual = tictactoe.hasSimulatedComputerTurns();
        assertTrue(actual);
    }


}
