package Lib.Model.TwoPlayerTurn.VerboseTwoPlayerTurn;

import Lib.Model.TwoPlayerTurn.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TurnMessagingOrderShuntTest implements Player, TurnMessageView {

    private String logString = "";

    @Test
    void IfPlayedOnce_ShouldShowTurnMessageBeforePlaying() {
        VerboseTwoPlayerTurn sut = new VerboseTwoPlayerTurn(this, this, this);

        sut.play();

        String actual = logString;
        String expected = "showTurnMessageFor play ";
        assertEquals(expected, actual);
    }

    public void playMove() {
        logString += "play ";
    }

    public void showTurnMessageFor(Object player) {
        logString += "showTurnMessageFor ";
    }
}
