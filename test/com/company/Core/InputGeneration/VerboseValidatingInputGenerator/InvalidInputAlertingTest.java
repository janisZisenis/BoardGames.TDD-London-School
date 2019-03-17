package com.company.Core.InputGeneration.VerboseValidatingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.ValidatingInputGenerator.CountingGeneratorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class InvalidInputAlertingTest {

    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private InputRefereeMock referee = new InputRefereeMock();
    private VerboseValidatingInputGenerator sut = new VerboseValidatingInputGenerator(generator, referee);

    private Input[] generated;
    private Input[] valids;

    @Test
    void IfSecondInputIsValid_ShouldAlertTheFirstInput() {
        makeSecondInputIsValid();

        referee.expectLastAlertedIs(new Input(0, 0));

        sut.generate();

        referee.verifyAll();
    }

    @Test
    void IfThirdInputIsValid_ShouldAlertTheSecondInput() {
        makeThirdInputIsValid();

        referee.expectLastAlertedIs(new Input(0, 1));

        sut.generate();

        referee.verifyAll();
    }

    private void makeSecondInputIsValid() {
        generated = new Input[] { new Input(0, 0),
                                  new Input(0, 1) };
        generator.setGeneratedInputs(generated);

        valids = new Input[] { generated[1] };
        referee.setValidInputs(valids);
    }

    private void makeThirdInputIsValid() {
        generated = new Input[] { new Input(0, 0),
                                  new Input(0, 1),
                                  new Input(1, 1) };
        generator.setGeneratedInputs(generated);

        valids = new Input[] { generated[2] };
        referee.setValidInputs(valids);
    }


    public class InputRefereeMock extends InputRefereeStub {

        private Input expectedLastAlerted;
        private Input actualLastAlerted;

        private boolean hasAlerted = false;

        public void alertIsInvalid(Input input) {
            hasAlerted = true;
            actualLastAlerted = input;
        }

        public void expectLastAlertedIs(Input input) {
            expectedLastAlerted = input;
        }

        public void verifyAll() {
            assertTrue(hasAlerted);
            assertEquals(expectedLastAlerted, actualLastAlerted);
        }

    }

}
