package Presentation.ConfigureViewPresenter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigureViewPresenterTest {

    private ConfigureViewSpy view = new ConfigureViewSpy();
    private PlayerTypeProviderStub provider = new PlayerTypeProviderStub();
    private ConfigureViewPresenter sut = new ConfigureViewPresenter(view, provider);

    @Test
    void IfNoDistinctPlayerTypeIsProvided_ShouldDisableStartButton() {
        provider.setHasDistinctPlayerType(false);

        sut.update();

        assertHasDisabledStartButton();
    }

    @Test
    void IfDistinctPlayerTypeIsProvided_ShouldEnableStartButton() {
        provider.setHasDistinctPlayerType(true);

        sut.update();

        assertHasEnabledStartButton();
    }

    @Test
    void IfNoDistinctPlayerTypeIsProvided_ShouldNotEnableStartButton() {
        provider.setHasDistinctPlayerType(false);

        sut.update();

        assertHasNotEnabledStartButton();
    }

    @Test
    void IfDistinctPlayerTypeIsProvided_ShouldNotDisableStartButton() {
        provider.setHasDistinctPlayerType(true);

        sut.update();

        assertHasNotDisabledStartButton();
    }

    private void assertHasNotDisabledStartButton() {
        boolean actual = view.hasDisabledStartButton();
        assertFalse(actual);
    }

    private void assertHasNotEnabledStartButton() {
        boolean actual = view.hasEnabledStartButton();
        assertFalse(actual);
    }

    private void assertHasEnabledStartButton() {
        boolean actual = view.hasEnabledStartButton();
        assertTrue(actual);
    }

    private void assertHasDisabledStartButton() {
        boolean actual = view.hasDisabledStartButton();
        assertTrue(actual);
    }

}
