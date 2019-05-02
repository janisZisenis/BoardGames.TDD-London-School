package Lib.Players.MessagingPlayer;

import Lib.Data.Field.Field;
import Lib.Data.Input.Input;
import Lib.Data.Mark;
import Lib.Players.CountingGeneratorStub;
import Lib.Players.MarkFieldServiceDummy;
import Lib.Players.PlayerContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PublishingTheMoveTest {

    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private MarkFieldServiceDummy markService = new MarkFieldServiceDummy();
    private PlayerMessengerSpy messenger = new PlayerMessengerSpy();
    private MessagingPlayer sut;

    @Test
    void IfRow0Column1GetsMarked_ShouldPublishTheMarkedFieldWithRow0Column1() {
        makeJohnWillMarkRow0Column1();

        sut.playMove();

        Field actual = messenger.getPublishedField();
        Field expected = new Field(0, 1);
        assertEquals(expected, actual);
    }

    @Test
    void IfRow2Column2GetsMarked_ShouldPublishTheMarkedFieldWithRow2Column2() {
        makeHaleyWillMarkRow2Column2();

        sut.playMove();

        Field actual = messenger.getPublishedField();
        Field expected = new Field(2, 2);
        assertEquals(expected, actual);
    }

    @Test
    void IfJohnPlayedMove_ShouldPublishItsMark() {
        makeJohnWillMarkRow0Column1();

        sut.playMove();

        Mark actual = messenger.getPublishedMark();
        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }

    @Test
    void IfHaleyPlayedMove_ShouldPublishItsMark() {
        makeHaleyWillMarkRow2Column2();

        sut.playMove();

        Mark actual = messenger.getPublishedMark();
        Mark expected = Mark.Haley;
        assertEquals(expected, actual);
    }

    private void makeHaleyWillMarkRow2Column2() {
        makePlayerIs(Mark.Haley);
        Input[] inputs = { new Input(2, 2) };
        generator.setGeneratedInputs(inputs);
    }


    private void makeJohnWillMarkRow0Column1() {
        makePlayerIs(Mark.John);
        Input[] inputs = { new Input(0, 1) };
        generator.setGeneratedInputs(inputs);
    }

    private void makePlayerIs(Mark m) {
        PlayerContext context = new PlayerContext(generator, markService, m);
        sut = new MessagingPlayer(context, messenger);
    }

}
