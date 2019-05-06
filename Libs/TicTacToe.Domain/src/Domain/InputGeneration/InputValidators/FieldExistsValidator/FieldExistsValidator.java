package Domain.InputGeneration.InputValidators.FieldExistsValidator;

import Domain.Data.BoardBoundaries;
import InputGeneration.Input.Input;
import InputGeneration.InputValidatorImp.InputValidator;

public class FieldExistsValidator implements InputValidator {

    private final int rowColumnCount = BoardBoundaries.rowColumnCount;

    public boolean isValid(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return isOutOfBounds(row) && isOutOfBounds(col);
    }

    private boolean isOutOfBounds(int i) {
        return i >= 0 && i < rowColumnCount;
    }

}
