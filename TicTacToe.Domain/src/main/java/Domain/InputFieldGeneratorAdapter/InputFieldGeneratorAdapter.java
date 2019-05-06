package Domain.InputFieldGeneratorAdapter;

import Domain.Data.Field.Field;
import Domain.Turn.FieldGenerator;
import InputGeneration.Input.Input;
import InputGeneration.InputGenerator;

public class InputFieldGeneratorAdapter implements FieldGenerator {

    private final InputGenerator generator;

    public InputFieldGeneratorAdapter(InputGenerator generator) {
        this.generator = generator;
    }

    public Field generate() {
        Input input = generateInput();
        return makeField(input);
    }

    private Input generateInput() {
        return generator.generate();
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return new Field(row, col);
    }


}
