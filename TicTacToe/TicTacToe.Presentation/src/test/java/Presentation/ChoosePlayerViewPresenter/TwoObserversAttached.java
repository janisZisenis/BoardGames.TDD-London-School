package Presentation.ChoosePlayerViewPresenter;

import Domain.Board.BoardDecorators.ObservableBoard.ObserverSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoObserversAttached {

    private ChoosePlayerViewDummy view = new ChoosePlayerViewDummy();
    private ChoosePlayerViewPresenter sut = new ChoosePlayerViewPresenter(view);
    private ObserverSpy first = new ObserverSpy();
    private ObserverSpy second = new ObserverSpy();

    @BeforeEach
    void setUp() {
        sut.attach(first);
        sut.attach(second);
    }

    @Test
    void IfHumanGetsClicked_ShouldUpdateFirst() {
        sut.onHumanClicked();

        assertWasUpdated(first);
    }

    @Test
    void IfHumanGetsClicked_ShouldUpdateSecond() {
        sut.onHumanClicked();

        assertWasUpdated(second);
    }

    @Test
    void IfHumbleGetsClicked_ShouldUpdateSecond() {
        sut.onHumbleClicked();

        assertWasUpdated(second);
    }

    @Test
    void IfInvincibleGetsClicked_ShouldUpdateSecond() {
        sut.onInvincibleClicked();

        assertWasUpdated(second);
    }


    private void assertWasUpdated(ObserverSpy observer) {
        boolean actual = observer.wasUpdated();
        assertTrue(actual);
    }
}
