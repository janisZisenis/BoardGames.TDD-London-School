package GuiGaming.TicTacToeFacade;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProviderStub;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProviderDummy;
import InputGeneration.InputProcessorSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccessingMarkedFieldsTest {

    private WinningLineProviderDummy winningLineProvider = new WinningLineProviderDummy();
    private MarkedFieldProviderStub markedFieldProvider = new MarkedFieldProviderStub();
    private InputProcessorSpy processor = new InputProcessorSpy();
    private TicTacToeFacade sut = new TicTacToeFacade(winningLineProvider, processor, markedFieldProvider);

    @Test
    void IfFieldR0C0IsMarked_FieldR0C0ShouldBeMarkedEither() {
        Field field = new Field(0, 0);
        markedFieldProvider.addMarkedField(field, Mark.John);

        assertIsMarked(field);
    }

    @Test
    void IfFieldR1C2IsMarked_FieldR1C2ShouldBeMarkedEither() {
        Field field = new Field(1, 2);

        assertIsNotMarked(field);
    }

    @Test
    void IfFieldIsMarkedWithJohn_ShouldBeJohnsField() {
        Field field = new Field(0, 0);
        markedFieldProvider.addMarkedField(field, Mark.John);

        assertIsJohns(field);
    }

    @Test
    void IfFieldIsMarkedWithHaley_ShouldHaleysField() {
        Field field = new Field(0, 0);
        markedFieldProvider.addMarkedField(field, Mark.Haley);

        assertIsHaleys(field);
    }

    private void assertIsHaleys(Field field) {
        Mark actual = sut.getMarkAt(field);
        Mark expected = Mark.Haley;
        assertEquals(expected, actual);
    }

    private void assertIsJohns(Field field) {
        Mark actual = sut.getMarkAt(field);
        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }

    private void assertIsNotMarked(Field f) {
        boolean actual = sut.isMarked(f);
        assertFalse(actual);
    }

    private void assertIsMarked(Field field) {
        boolean actual = sut.isMarked(field);
        assertTrue(actual);
    }

}
