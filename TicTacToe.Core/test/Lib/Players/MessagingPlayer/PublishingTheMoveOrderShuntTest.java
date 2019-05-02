package Lib.Players.MessagingPlayer;

import Lib.Data.Field.Field;
import Lib.Data.Input.Input;
import Lib.Data.Mark;
import Lib.Players.CountingGeneratorStub;
import Lib.Players.MarkFieldService;
import Lib.Players.PlayerContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublishingTheMoveOrderShuntTest implements MarkFieldService, PlayerMessenger {

    private String logString = "";

    @Test
    void IfGetsPlayed_ShouldMarkTheFieldBeforePublishing() {
        MessagingPlayer sut = makeMessagingPlayer();

        sut.playMove();

        String actual = logString;
        String expected = "mark publishPlayedMove ";
        assertEquals(expected, actual);
    }

    public void mark(Field f, Mark m) {
        logString += "mark ";
    }

    public void publishPlayedMove(Mark m, Field f) {
        logString += "publishPlayedMove ";
    }


    private MessagingPlayer makeMessagingPlayer() {
        PlayerContext context = makePlayerContext();
        return new MessagingPlayer(context, this);
    }

    private PlayerContext makePlayerContext() {
        CountingGeneratorStub generator = new CountingGeneratorStub();
        generator.setGeneratedInputs(new Input[]{ new Input(0, 1)});
        return new PlayerContext(generator, this, Mark.John);
    }
}
