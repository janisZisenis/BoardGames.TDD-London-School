package Messaging.WinnerMessageProviderImp;

import Domain.Data.Mark;
import Mapping.MarkToStringMapperStub;
import Messaging.MessageProviders.GameOverMessageProvider.WinnerMessageProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class WinnerMessageProviderImpTest {

    private WinnerProviderStub provider = new WinnerProviderStub();
    private MarkToStringMapperStub mapper = new MarkToStringMapperStub();
    private WinnerMessageProviderImp sut = new WinnerMessageProviderImp(provider, mapper);

    @Test
    void IfNoWinnerIsProvided_ShouldThrowException() {
        provider.setHasWinner(false);

        Executable act = () -> sut.getWinningMessage();

        assertThrows(WinnerMessageProvider.NoWinnerAvailable.class, act);
    }

    @Test
    void IfNoWinnerIsProvided_ShouldNotProvideAWinnerEither() {
        provider.setHasWinner(false);

        boolean actual = sut.hasWinner();
        assertFalse(actual);
    }

    @Test
    void IfWinnerIsProvided_ShouldProvideAWinnerEither() {
        provider.setHasWinner(true);

        boolean actual = sut.hasWinner();
        assertTrue(actual);
    }

    @Test
    void IfJohnIsProvidedAsWinner_ShouldProvideTheMappedStringForJohn() {
        provider.setHasWinner(true);
        provider.setWinner(Mark.John);
        mapper.setMappedStringForMark(Mark.John, "John");

        String actual = sut.getWinningMessage();
        String expected = "John";
        assertEquals(expected, actual);
    }

    @Test
    void IfHaleyIsProvidedAsWinner_ShouldProvideTheMappedStringForHaley() {
        provider.setHasWinner(true);
        provider.setWinner(Mark.Haley);
        mapper.setMappedStringForMark(Mark.Haley, "Haley");

        String actual = sut.getWinningMessage();
        String expected = "Haley";
        assertEquals(expected, actual);
    }

}
