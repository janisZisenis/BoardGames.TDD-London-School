package com.company.Core.InputGeneration.VerboseValidatingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.CountingGeneratorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidInputGenerationTest {

    private InputRefereeStub referee = new InputRefereeStub();
    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private VerboseValidatingInputGenerator sut = new VerboseValidatingInputGenerator(generator, referee);

    private Input[] generated;
    private Input[] valids;

    @Test
    void IfRefereeValidatesFirstInput_ItShouldBeTheFirst() {
        makeFirstGeneratedInputIsValid();

        Input actual = sut.generate();

        Input expected = generated[0];
        assertEquals(expected, actual);
    }

    @Test
    void IfRefereeInvalidatesFirstInput_ItShouldBeTheSecond() {
        makeSecondGeneratedInputIsValid();

        Input actual = sut.generate();

        Input expected = generated[1];
        assertEquals(expected, actual);
    }

    @Test
    void IfRefereeInvalidatesFirstAndSecondInput_ItShouldBeTheThird() {
        makeThirdGeneratedInputIsValid();

        Input actual = sut.generate();

        Input expected = generated[2];
        assertEquals(expected, actual);
    }

    private void makeFirstGeneratedInputIsValid() {
        generated = new Input[] { new Input (0, 1) };
        generator.setGeneratedInputs(generated);

        valids = new Input[] { generated[0] };
        referee.setValidInputs(valids);
    }

    private void makeSecondGeneratedInputIsValid() {
        generated = new Input[] { new Input(0, 1),
                                  new Input(0, 2) };
        generator.setGeneratedInputs(generated);

        valids = new Input[] { generated[1] };
        referee.setValidInputs(valids);
    }

    private void makeThirdGeneratedInputIsValid() {
        generated = new Input[] { new Input(0, 1),
                                  new Input(0, 2),
                                  new Input(0, 0) };
        generator.setGeneratedInputs(generated);

        valids = new Input[] { generated[2] };
        referee.setValidInputs(valids);
    }

}
