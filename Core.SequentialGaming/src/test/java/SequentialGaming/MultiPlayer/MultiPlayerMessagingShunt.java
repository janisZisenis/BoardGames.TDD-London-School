package SequentialGaming.MultiPlayer;

import SequentialGaming.DelegatingGame.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiPlayerMessagingShunt implements Player, MultiPlayerMessenger {

    private String logString = "";
    private Object published = null;

    @Test
    void IfGetsPlayed_ShouldPublishCurrentPlayer() {
        MultiPlayer sut = new MultiPlayer(this, this);

        sut.play();

        assertHasPublished(this);
    }

    @Test
    void IfGetsPlayed_ShouldPublishBeforePlaying() {
        MultiPlayer sut = new MultiPlayer(this, this);

        sut.play();

        assertLogStringEquals("publishPlayer play ");
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

    public void publishPlayer(Object o) {
        published = o;
        logString += "publishPlayer ";
    }
}
