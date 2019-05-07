package SequentialGaming.MultiTurn;

import SequentialGaming.DelegatingGame.Turn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiTurnMessagingShunt implements Turn, MultiTurnMessenger {

    private String logString = "";
    private Object published = null;

    @Test
    void IfGetsPlayed_ShouldPublishTheCurrentTurn() {
        MultiTurn sut = new MultiTurn(this, this);

        sut.play();

        assertHasPublished(this);
    }

    @Test
    void IfGetsPlayed_ShouldPublishBeforePlaying() {
        MultiTurn sut = new MultiTurn(this, this);

        sut.play();

        assertLogStringEquals("publishTurn play ");
    }

    private void assertHasPublished(Object expected) {
        Object actual = published;
        assertEquals(expected, actual);
    }

    private void assertLogStringEquals(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }


    public void play() {
        logString += "play ";
    }

    public void publishTurn(Object o) {
        published = o;
        logString += "publishTurn ";
    }
}
