package Lib.Model.TwoPlayerTurn.MessagingTwoPlayerTurn;

import Lib.Model.TwoPlayerTurn.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TurnMessagingOrderShuntTest implements Player, TurnMessenger {

    private String logString = "";

    @Test
    void IfPlayedOnce_ShouldShowTurnMessageBeforePlaying() {
        MessagingTwoPlayerTurn sut = new MessagingTwoPlayerTurn(this, this, this);

        sut.play();

        String actual = logString;
        String expected = "publishTurnMessageFor play ";
        assertEquals(expected, actual);
    }

    public void playMove() {
        logString += "play ";
    }

    public void publishTurnMessageFor(Object player) {
        logString += "publishTurnMessageFor ";
    }
}
