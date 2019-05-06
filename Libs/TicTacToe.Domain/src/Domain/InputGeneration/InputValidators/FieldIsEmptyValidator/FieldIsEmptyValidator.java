package Domain.InputGeneration.InputValidators.FieldIsEmptyValidator;

import Domain.Data.Field.Field;
import InputGeneration.Input.Input;
import InputGeneration.ValidatingInputGenerator.InputValidator;

public class FieldIsEmptyValidator implements InputValidator {
    private final FieldIsEmptyProvider provider;

    public FieldIsEmptyValidator(FieldIsEmptyProvider provider) {
        this.provider = provider;
    }

    public boolean isValid(Input input) {
        Field f = makeField(input);
        return provider.isEmpty(f);
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return new Field (row, col);
    }
}
