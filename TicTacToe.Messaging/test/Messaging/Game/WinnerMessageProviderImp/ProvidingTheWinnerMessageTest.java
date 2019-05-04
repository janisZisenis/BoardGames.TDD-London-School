package Messaging.Game.WinnerMessageProviderImp;

import Lib.Board.Mark;
import Mappers.MarkToStringMapperStub;
import Messaging.Game.GameOverMessageProviderImp.WinnerMessageProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ProvidingTheWinnerMessageTest {

    private WinnerProviderStub provider = new WinnerProviderStub();
    private MarkToStringMapperStub mapper = new MarkToStringMapperStub();
    private WinnerMessageProviderImp sut = new WinnerMessageProviderImp(provider, mapper);

    @Test
    void IfNoWinnerIsProvided_GettingTheMessageShouldThrowException() {
        provider.setHasWinner(false);

        Executable act = () -> { sut.getWinningMessage(); };

        assertThrows(WinnerMessageProvider.NoWinnerAvailable.class, act);
    }

    @Test
    void IfNoWinnerIsProvided_ShouldNotProvideAWinnerEither() {
        provider.setHasWinner(false);

        boolean actual = sut.hasWinner();
        assertFalse(actual);
    }

    @Test
    void IfWinnerIsProvided_ShouldProvideAWinnerToo() {
        provider.setHasWinner(true);

        boolean actual = sut.hasWinner();
        assertTrue(actual);
    }

    @Test
    void IfJohnIsProvidedAsWinner_ShouldProvideTheMappedStringForJohn() {
        provider.setHasWinner(true);
        provider.setWinner(Mark.John);
        mapper.setMappedStringForMark(Mark.John, "John");
        mapper.setMappedStringForMark(Mark.Haley, "Haley");

        String actual = sut.getWinningMessage();
        String expected = "John";
        assertEquals(expected, actual);
    }

    @Test
    void IfHaleyIsProvidedAsWinner_ShouldProvideTheMappedStringForHaley() {
        provider.setHasWinner(true);
        provider.setWinner(Mark.Haley);
        mapper.setMappedStringForMark(Mark.John, "John");
        mapper.setMappedStringForMark(Mark.Haley, "Haley");

        String actual = sut.getWinningMessage();
        String expected = "Haley";
        assertEquals(expected, actual);
    }

}
