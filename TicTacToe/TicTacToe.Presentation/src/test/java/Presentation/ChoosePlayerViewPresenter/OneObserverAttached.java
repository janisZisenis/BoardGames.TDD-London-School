package Presentation.ChoosePlayerViewPresenter;

import Domain.Board.BoardDecorators.ObservableBoard.ObserverSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OneObserverAttached {

    private ChoosePlayerViewDummy view = new ChoosePlayerViewDummy();
    private ChoosePlayerViewPresenter sut = new ChoosePlayerViewPresenter(view);
    private ObserverSpy observer = new ObserverSpy();

    @BeforeEach
    void setUp() {
        sut.attach(observer);
    }

    @Test
    void IfHumanGetsClicked_ShouldUpdateObserver() {
        sut.onHumanClicked();

        assertWasUpdated();
    }

    @Test
    void IfHumbleGetsClicked_ShouldUpdateObserver() {
        sut.onHumbleClicked();

        assertWasUpdated();
    }

    @Test
    void IfInvincibleGetsClicked_ShouldUpdateObserver() {
        sut.onInvincibleClicked();

        assertWasUpdated();
    }

    private void assertWasUpdated() {
        boolean actual = observer.wasUpdated();
        assertTrue(actual);
    }
}
