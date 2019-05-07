package InputGeneration.ValidatingInputGenerator;

import InputGeneration.CountingGeneratorStub;
import InputGeneration.Input.Input;
import InputGeneration.ValidatingInputGenerator.AlertingInputGenerator.AlertingInputGenerator;
import InputGeneration.ValidatingInputGenerator.AlertingInputGenerator.InputAlerterDummy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatingInputGeneratorTest {

    private CountingGeneratorStub generator;
    private InputValidatorStub validator;
    private ValidatingInputGenerator sut;

    private Input[] generatedInputs;


    private static ValidatingInputGeneratorTestContext makeValidatingContext() {
        CountingGeneratorStub generator = new CountingGeneratorStub();
        InputValidatorStub validator = new InputValidatorStub();
        ValidatingInputGenerator sut = new ValidatingInputGenerator(generator, validator);
        return new ValidatingInputGeneratorTestContext(generator, validator, sut);
    }

    private static ValidatingInputGeneratorTestContext makeAlertingContext() {
        CountingGeneratorStub generator = new CountingGeneratorStub();
        InputValidatorStub validator = new InputValidatorStub();
        InputAlerterDummy alerter = new InputAlerterDummy();
        ValidatingInputGenerator sut = new AlertingInputGenerator(generator, validator, alerter);
        return new ValidatingInputGeneratorTestContext(generator, validator, sut);
    }

    private static Stream<ValidatingInputGeneratorTestContext> makeTestContexts() {
        return Stream.of(
            makeValidatingContext(),
            makeAlertingContext()
        );
    }

    @MethodSource("makeTestContexts")
    @ParameterizedTest
    void IfFirstInputIsValid_ShouldBeTheFirstInput(ValidatingInputGeneratorTestContext context) {
        initFixture(context);
        makeFirstInputIsValid();

        Input actual = sut.generate();

        Input expected = generatedInputs[0];
        assertEquals(expected, actual);

        generatedInputs = new Input[]{};
    }

    @MethodSource("makeTestContexts")
    @ParameterizedTest
    void IfOnlySecondInputIsValid_ShouldBeTheSecondInput(ValidatingInputGeneratorTestContext context) {
        initFixture(context);
        makeOnlySecondInputIsValid();

        Input actual = sut.generate();

        Input expected = generatedInputs[1];
        assertEquals(expected, actual);

        generatedInputs = new Input[]{};
    }

    @MethodSource("makeTestContexts")
    @ParameterizedTest
    void IfOnlyThirdInputIsValid_ShouldBeTheThirdInput(ValidatingInputGeneratorTestContext context) {
        initFixture(context);
        makeOnlyThirdInputIsValid();

        Input actual = sut.generate();

        Input expected = generatedInputs[2];
        assertEquals(expected, actual);

        generatedInputs = new Input[]{};
    }

    private void initFixture(ValidatingInputGeneratorTestContext context) {
        this.generator = context.getGeneratorStub();
        this.validator = context.getValidatorStub();
        this.sut = context.getSut();
    }

    private void makeFirstInputIsValid() {
        generatedInputs = new Input[] { new Input(0, 1) };

        generator.setGeneratedInputs(generatedInputs);
        validator.setValidInputs(generatedInputs);
    }

    private void makeOnlySecondInputIsValid() {
        generatedInputs = new Input[] { new Input(0, 1),
                                        new Input(1, 2) };

        Input[] validInputs = { generatedInputs[1] };

        generator.setGeneratedInputs(generatedInputs);
        validator.setValidInputs(validInputs);
    }

    private void makeOnlyThirdInputIsValid() {
        generatedInputs = new Input[] { new Input(0, 1),
                                        new Input(1, 2),
                                        new Input(2, 3) };

        Input[] validInputs = { generatedInputs[2] };

        generator.setGeneratedInputs(generatedInputs);
        validator.setValidInputs(validInputs);
    }

}