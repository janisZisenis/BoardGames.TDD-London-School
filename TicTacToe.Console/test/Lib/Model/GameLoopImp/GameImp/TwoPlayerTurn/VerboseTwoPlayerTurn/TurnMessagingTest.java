package Lib.Model.GameLoopImp.GameImp.TwoPlayerTurn.VerboseTwoPlayerTurn;

import Lib.Model.GameLoopImp.GameImp.TwoPlayerTurn.PlayerDummy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TurnMessagingTest {

    private PlayerDummy first = new PlayerDummy();
    private PlayerDummy second = new PlayerDummy();
    private TurnMessageViewSpy view = new TurnMessageViewSpy();
    private VerboseTwoPlayerTurn sut = new VerboseTwoPlayerTurn(first, second, view);

    @Test
    void IfPlayedOnce_ShouldShowTurnMessageWithFirstPlayer() {
        sut.play();

        Object actual = view.getShownPlayer();
        Object expected = first;
        assertEquals(expected, actual);
    }

    @Test
    void IfPlayedTwice_ShouldShowTurnMessageWithSecondPlayer() {
        sut.play();
        sut.play();

        Object actual = view.getShownPlayer();
        Object expected = second;
        assertEquals(expected, actual);
    }

}
