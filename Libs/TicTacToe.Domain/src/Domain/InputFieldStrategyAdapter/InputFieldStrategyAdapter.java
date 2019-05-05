package Domain.InputFieldStrategyAdapter;

import Domain.Data.Field.Field;
import Domain.Input.Input;
import Domain.Players.InputGenerator;
import Domain.Turn.InputFieldStrategy;

public class InputFieldStrategyAdapter implements InputFieldStrategy {

    private final InputGenerator generator;

    public InputFieldStrategyAdapter(InputGenerator generator) {
        this.generator = generator;
    }

    public Field generateField() {
        Input input = generator.generate();
        return makeField(input);
    }

    public Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return new Field(row, col);
    }

}
