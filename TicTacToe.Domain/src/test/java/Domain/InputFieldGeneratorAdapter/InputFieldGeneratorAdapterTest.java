package Domain.InputFieldGeneratorAdapter;

import Domain.Data.Field.Field;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputFieldGeneratorAdapterTest {

    private InputGeneratorStub generator = new InputGeneratorStub();
    private InputFieldGeneratorAdapter sut = new InputFieldGeneratorAdapter(generator);

    @Test
    void IfInputR0C0IsProvided_ShouldGenerateFieldWithR0C0() {
        generator.setGeneratedInput(new Input(0, 0));

        Field actual = sut.generate();

        Field expected = new Field(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    void IfInputR2C1IsProvided_ShouldGenerateFieldWithR2C1() {
        generator.setGeneratedInput(new Input(2, 1));

        Field actual = sut.generate();

        Field expected = new Field(2, 1);
        assertEquals(expected, actual);
    }

}
