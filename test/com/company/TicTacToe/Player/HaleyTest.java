package com.company.TicTacToe.Player;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputGeneratorStub;
import com.company.TicTacToe.Board.Player;
import com.company.TicTacToe.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HaleyTest {

    InputGeneratorStub generator = new InputGeneratorStub();
    MarkFieldServiceMock markService = new MarkFieldServiceMock();
    Haley sut = new Haley(generator, markService);

    @Test
    void IfInputHasRow1AndColumn2_JohnShouldMarkFieldRow1Column2WithHisMark() {
        Input in = new Input(1, 2);
        makeGeneratorReturns(in);
        Field f = new Field(1, 2);
        makeMarkServiceExpects(f, Player.Haley);

        sut.play();

        markService.verifyAll();
    }

    @Test
    void IfInputHasRow2AndColumn1_JohnShouldMarkFieldRow2Column1WithHisMark() {
        Input in = new Input(2, 1);
        makeGeneratorReturns(in);
        Field f = new Field(2, 1);
        makeMarkServiceExpects(f, Player.Haley);

        sut.play();

        markService.verifyAll();
    }

    private void makeMarkServiceExpects(Field f, Player p) {
        markService.expectFieldWasMarkedWith(p, f);
    }

    private void makeGeneratorReturns(Input in) {
        Input[] inputs = { in };
        generator.setUserInputs(inputs);
    }

    public class MarkFieldServiceMock implements MarkFieldService {
        private boolean wasMarked = false;

        private Player expectedPlayer;
        private Field expectedField;

        private Player markedPlayer;
        private Field markedField;

        public void expectFieldWasMarkedWith(Player p, Field f) {
            this.expectedPlayer = p;
            this.expectedField = f;
        }

        public void verifyAll() {
            assertTrue(wasMarked);
            assertEquals(expectedPlayer, markedPlayer);
            assertEquals(expectedField, markedField);
        }

        public void mark(Field f, Player p) {
            wasMarked = true;
            markedField = f;
            markedPlayer = p;
        }
    }

}
