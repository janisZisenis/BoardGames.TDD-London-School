package Domain.InputFieldStrategyAdapter;

import Domain.Data.Field.Field;
import Domain.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputFieldStrategyAdapterTest {

    private InputGeneratorStub generator = new InputGeneratorStub();
    private InputFieldStrategyAdapter sut = new InputFieldStrategyAdapter(generator);

    @Test
    void IfInputR0C0IsProvided_ShouldGenerateFieldWithR0C0() {
        generator.setGeneratedInput(new Input(0, 0));

        Field actual = sut.generateField();

        Field expected = new Field(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    void IfInputR2C1IsProvided_ShouldGenerateFieldWithR2C1() {
        generator.setGeneratedInput(new Input(2, 1));

        Field actual = sut.generateField();

        Field expected = new Field(2, 1);
        assertEquals(expected, actual);
    }

}
