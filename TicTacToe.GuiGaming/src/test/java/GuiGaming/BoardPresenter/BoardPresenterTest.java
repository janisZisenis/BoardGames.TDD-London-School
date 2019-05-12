package GuiGaming.BoardPresenter;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProviderStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BoardPresenterTest {

    private BoardViewSpy view = new BoardViewSpy();
    private MarkedFieldProviderStub provider = new MarkedFieldProviderStub();
    private BoardPresenter sut = new BoardPresenter(provider, view);

    @Test
    void IfFieldR0C0IsMarked_ShouldSetR0C0() {
        Field field = new Field(0, 0);
        provider.addMarkedField(field, Mark.John);

        sut.onFieldUpdated(field);

        assertSetFieldEquals(new Field(0, 0));
    }

    @Test
    void IfFieldR1C2IsMarked_ShouldSetR0C0() {
        Field field = new Field(1, 2);
        provider.addMarkedField(field, Mark.John);

        sut.onFieldUpdated(field);

        assertSetFieldEquals(new Field(1, 2));
    }

    @Test
    void IfFieldIsMarkedWithJohn_ShouldSetJohn() {
        Field field = new Field(0, 0);
        provider.addMarkedField(field, Mark.John);

        sut.onFieldUpdated(field);

        assertSetMarkEquals(Mark.John);
    }

    @Test
    void IfFieldIsMarkedWithHaley_ShouldSetHaley() {
        Field field = new Field(0, 0);
        provider.addMarkedField(field, Mark.Haley);

        sut.onFieldUpdated(field);

        assertSetMarkEquals(Mark.Haley);
    }

    private void assertSetFieldEquals(Field expected) {
        Field actual = view.getSetField();
        assertEquals(expected, actual);
    }

    private void assertSetMarkEquals(Mark expected) {
        Mark actual = view.getSetMark();
        assertEquals(expected, actual);
    }

    @Test
    void IfFieldIsUnmarked_ShouldNotSetField() {
        Field field = new Field(0, 0);

        sut.onFieldUpdated(field);

        assertHasNotSetField();
    }

    private void assertHasNotSetField() {
        boolean actual = view.hasSetField();
        assertFalse(actual);
    }


    @Test
    void IfFieldIsUnmarked_ShouldClearTheField() {
        Field field = new Field(0, 0);

        sut.onFieldUpdated(field);

        assertClearedFieldEquals(new Field(0, 0));
    }

    private void assertClearedFieldEquals(Field expected) {
        Field actual = view.getCleared();
        assertEquals(expected, actual);
    }


    @Test
    void IfFieldIsMarked_ShouldNotClearTheField() {
        Field field = new Field(0, 0);
        provider.addMarkedField(field, Mark.John);

        sut.onFieldUpdated(field);

        assertHasNotCleared();
    }

    private void assertHasNotCleared() {
        boolean actual = view.hasCleared();
        assertFalse(actual);
    }

}
