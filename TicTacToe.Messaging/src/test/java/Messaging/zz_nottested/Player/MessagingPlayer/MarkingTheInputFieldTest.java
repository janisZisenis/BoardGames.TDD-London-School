package Messaging.zz_nottested.Player.MessagingPlayer;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import InputGeneration.CountingGeneratorStub;
import InputGeneration.Input.Input;
import Messaging.zz_nottested.Players.PlayerContext;
import Messaging.zz_nottested.Player.Players.MarkFieldServiceMock;
import org.junit.jupiter.api.Test;

public class MarkingTheInputFieldTest {
    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private MarkFieldServiceMock markService = new MarkFieldServiceMock();
    private PlayerMessengerDummy messenger = new PlayerMessengerDummy();
    private MessagingPlayer sut;

    @Test
    void IfInputHasR1C2_JohnShouldMarkFieldR1C2WithJohn() {
        makeJohnWillMarkR1C1();
        makeMockExpectsJohnMarksR1C1();

        sut.playMove();

        markService.verifyAll();
    }

    @Test
    void IfInputHasR2C1_JohnShouldMarkFieldR2C1WithJohn() {
        makeJohnWillMarkR2C0();
        makeMockExpectsJohnMarksR2C0();

        sut.playMove();

        markService.verifyAll();
    }

    @Test
    void IfInputHasR1C2_HaleyShouldMarkFieldR1C2WithHaley() {
        makeHaleyWillMarkR1C1();
        makeMockExpectsHaleyMarksR1C1();

        sut.playMove();

        markService.verifyAll();
    }

    private void makePlayerIsJohn() {
        PlayerContext config = makePlayerContext(Mark.John);
        sut = makeMessagingPlayer(config, messenger);
    }

    private void makePlayerIsHaley() {
        PlayerContext config = makePlayerContext(Mark.Haley);
        sut = makeMessagingPlayer(config, messenger);
    }

    private MessagingPlayer makeMessagingPlayer(PlayerContext context, PlayerMessenger messenger) {
        return new MessagingPlayer(context, messenger);
    }

    private PlayerContext makePlayerContext(Mark mark) {
        return new PlayerContext(generator, markService, mark);
    }


    private void makeJohnWillMarkR1C1() {
        makePlayerIsJohn();
        makeGeneratorReturnsR1C1();
    }

    private void makeJohnWillMarkR2C0() {
        makePlayerIsJohn();
        makeGeneratorReturnsR2C0();
    }

    private void makeHaleyWillMarkR1C1() {
        makePlayerIsHaley();
        makeGeneratorReturnsR1C1();
    }


    private void makeGeneratorReturnsR2C0() {
        Input in = new Input(2, 0);
        Input[] inputs = { in };
        generator.setGeneratedInputs(inputs);
    }

    private void makeGeneratorReturnsR1C1() {
        Input in = new Input(1, 1);
        Input[] inputs = { in };
        generator.setGeneratedInputs(inputs);
    }


    private void makeMockExpectsJohnMarksR1C1() {
        Field f = new Field(1, 1);
        markService.expectFieldWasMarkedWith(Mark.John, f);
    }

    private void makeMockExpectsHaleyMarksR1C1() {
        Field f = new Field(1, 1);
        markService.expectFieldWasMarkedWith(Mark.Haley, f);
    }

    private void makeMockExpectsJohnMarksR2C0() {
        Field f = new Field(2, 0);
        markService.expectFieldWasMarkedWith(Mark.John, f);
    }
}
