package Game.MessagingGame;

import Lib.GameImp.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessagingGameTest implements Game, GameMessenger {

    private String logString = "";

    @Test
    void IfGetsPlayed_ShouldEncloseTheGameWithStartingAndEndingMessages() {
        MessagingGame sut = new MessagingGame(this, this);

        sut.play();

        assertLogStringIs("publishBeginningMessage play publishEndingMessage ");
    }

    private void assertLogStringIs(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public void play() {
        logString += "play ";
    }

    public void publishBeginningMessage() {
        logString += "publishBeginningMessage ";
    }

    public void publishEndingMessage() {
        logString += "publishEndingMessage ";
    }
}
