package Domain.InputFieldGeneratorAdapter;

import Domain.Data.Field.Field;
import Domain.Input.Input;
import Domain.Players.InputGenerator;
import Domain.Turn.FieldGenerator;

public class InputFieldGeneratorAdapter implements FieldGenerator {

    private final InputGenerator generator;

    public InputFieldGeneratorAdapter(InputGenerator generator) {
        this.generator = generator;
    }

    public Field generate() {
        Input input = generator.generate();
        return makeField(input);
    }

    public Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return new Field(row, col);
    }

}
