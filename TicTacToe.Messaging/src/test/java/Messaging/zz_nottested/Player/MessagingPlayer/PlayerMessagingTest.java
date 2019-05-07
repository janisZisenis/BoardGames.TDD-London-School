package Messaging.zz_nottested.Player.MessagingPlayer;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import InputGeneration.CountingGeneratorStub;
import InputGeneration.Input.Input;
import Messaging.zz_nottested.Players.PlayerContext;
import Messaging.zz_nottested.Player.Players.MarkFieldServiceDummy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlayerMessagingTest {

    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private MarkFieldServiceDummy markService = new MarkFieldServiceDummy();
    private PlayerMessengerSpy messenger = new PlayerMessengerSpy();
    private MessagingPlayer sut;

    @Test
    void IfR0C1GetsMarked_ShouldPublishTheMarkedFieldWithR0C1() {
        makePlayerWillMarkR0C1();

        sut.playMove();

        Field actual = messenger.getPublishedField();
        Field expected = new Field(0, 1);
        assertEquals(expected, actual);
    }

    @Test
    void IfR2C2GetsMarked_ShouldPublishTheMarkedFieldWithR2C2() {
        makePlayerWillMarkR2C2();

        sut.playMove();

        Field actual = messenger.getPublishedField();
        Field expected = new Field(2, 2);
        assertEquals(expected, actual);
    }


    private void makePlayerWillMarkR2C2() {
        makePlayer();
        Input[] inputs = { new Input(2, 2) };
        generator.setGeneratedInputs(inputs);
    }


    private void makePlayerWillMarkR0C1() {
        makePlayer();
        Input[] inputs = { new Input(0, 1) };
        generator.setGeneratedInputs(inputs);
    }

    private void makePlayer() {
        PlayerContext context = new PlayerContext(generator, markService, Mark.John);
        sut = new MessagingPlayer(context, messenger);
    }

}
