package com.company.TicTacToe.Player;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputGeneratorStub;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JohnTest {

    Mark mark = Mark.John;
    InputGeneratorStub generator = new InputGeneratorStub();
    MarkFieldServiceMock markService = new MarkFieldServiceMock();
    PlayerConfig config = new PlayerConfig(generator, markService, mark);
    Player sut = new Player(config);

    @Test
    void IfInputHasRow1AndColumn2_JohnShouldMarkFieldRow1Column2WithHisMark() {
        Input in = new Input(1, 2);
        makeGeneratorReturns(in);
        Field f = new Field(1, 2);
        makeMarkServiceExpects(f, mark);

        sut.play();

        markService.verifyAll();
    }

    @Test
    void IfInputHasRow2AndColumn1_JohnShouldMarkFieldRow2Column1WithHisMark() {
        Input in = new Input(2, 1);
        makeGeneratorReturns(in);
        Field f = new Field(2, 1);
        makeMarkServiceExpects(f, mark);

        sut.play();

        markService.verifyAll();
    }

    private void makeMarkServiceExpects(Field f, Mark p) {
        markService.expectFieldWasMarkedWith(p, f);
    }

    private void makeGeneratorReturns(Input in) {
        Input[] inputs = { in };
        generator.setUserInputs(inputs);
    }

}
