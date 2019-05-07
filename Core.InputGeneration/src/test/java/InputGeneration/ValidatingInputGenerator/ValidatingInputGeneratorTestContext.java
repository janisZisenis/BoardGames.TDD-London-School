package InputGeneration.ValidatingInputGenerator;

import InputGeneration.CountingGeneratorStub;

public class ValidatingInputGeneratorTestContext {

    private final CountingGeneratorStub generator;
    private final InputValidatorStub validator;
    private final ValidatingInputGenerator sut;

    public ValidatingInputGeneratorTestContext(CountingGeneratorStub genertor,
                                               InputValidatorStub validator,
                                               ValidatingInputGenerator sut) {
        this.generator = genertor;
        this.validator = validator;
        this.sut = sut;
    }

    public CountingGeneratorStub getGeneratorStub() {
        return generator;
    }

    public InputValidatorStub getValidatorStub() {
        return validator;
    }

    public ValidatingInputGenerator getSut() {
        return sut;
    }
}
