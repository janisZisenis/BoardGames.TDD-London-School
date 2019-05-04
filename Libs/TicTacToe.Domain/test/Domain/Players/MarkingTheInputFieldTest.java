package Domain.Players;

import Data.Field.Field;
import Domain.Board.Api.MarkFieldServiceMock;
import Domain.Board.Mark;
import Domain.Input.Input;
import org.junit.jupiter.api.Test;

public class MarkingTheInputFieldTest {

    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private MarkFieldServiceMock markService = new MarkFieldServiceMock();
    private PlayerImp sut;

    @Test
    void IfInputHasRow1AndColumn2_JohnShouldMarkFieldRow1Column2WithJohn() {
        makeJohnWillMarkRow1Column1();
        makeMockExpectsJohnMarksRow1Column1();

        sut.playMove();

        markService.verifyAll();
    }

    @Test
    void IfInputHasRow2AndColumn1_JohnShouldMarkFieldRow2Column1WithJohn() {
        makeJohnWillMarkRow2Column0();
        makeMockExpectsJohnMarksRow2Column0();

        sut.playMove();

        markService.verifyAll();
    }

    @Test
    void IfInputHasRow1AndColumn2_HaleyShouldMarkFieldRow1Column2WithHaley() {
        makeHaleyWillMarkRow1Column1();
        makeMockExpectsHaleyMarksRow1Column1();

        sut.playMove();

        markService.verifyAll();
    }

    private void makePlayerIsJohn() {
        PlayerContext context = makePlayerContext(Mark.John);
        sut = makePlayer(context);
    }

    private void makePlayerIsHaley() {
        PlayerContext context = makePlayerContext(Mark.Haley);
        sut = makePlayer(context);
    }

    private PlayerImp makePlayer(PlayerContext context) {
        return new PlayerImp(context);
    }

    private PlayerContext makePlayerContext(Mark mark) {
        return new PlayerContext(generator, markService, mark);
    }


    private void makeJohnWillMarkRow1Column1() {
        makePlayerIsJohn();
        makeGeneratorReturnsRow1Column1();
    }

    private void makeJohnWillMarkRow2Column0() {
        makePlayerIsJohn();
        makeGeneratorReturnsRow2Column0();
    }

    private void makeHaleyWillMarkRow1Column1() {
        makePlayerIsHaley();
        makeGeneratorReturnsRow1Column1();
    }


    private void makeGeneratorReturnsRow2Column0() {
        Input in = new Input(2, 0);
        Input[] inputs = { in };
        generator.setGeneratedInputs(inputs);
    }

    private void makeGeneratorReturnsRow1Column1() {
        Input in = new Input(1, 1);
        Input[] inputs = { in };
        generator.setGeneratedInputs(inputs);
    }


    private void makeMockExpectsJohnMarksRow1Column1() {
        Field f = new Field(1, 1);
        markService.expectFieldWasMarkedWith(Mark.John, f);
    }

    private void makeMockExpectsHaleyMarksRow1Column1() {
        Field f = new Field(1, 1);
        markService.expectFieldWasMarkedWith(Mark.Haley, f);
    }

    private void makeMockExpectsJohnMarksRow2Column0() {
        Field f = new Field(2, 0);
        markService.expectFieldWasMarkedWith(Mark.John, f);
    }
}
